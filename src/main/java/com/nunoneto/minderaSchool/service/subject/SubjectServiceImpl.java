package com.nunoneto.minderaSchool.service.subject;

import com.nunoneto.minderaSchool.converter.SubjectConverter;
import com.nunoneto.minderaSchool.dto.subject.CreateOrUpdateSubjectDto;
import com.nunoneto.minderaSchool.dto.subject.SubjectDetailsDto;
import com.nunoneto.minderaSchool.entity.SubjectEntity;
import com.nunoneto.minderaSchool.exception.ErrorMessages;
import com.nunoneto.minderaSchool.exception.exceptions.SubjectNotFoundException;
import com.nunoneto.minderaSchool.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectConverter subjectConverter;
    private final SubjectRepository subjectRepository;

    @Override
    public SubjectDetailsDto createSubject(CreateOrUpdateSubjectDto createOrUpdateSubjectDto) {
        SubjectEntity subjectEntity = subjectConverter.convertToEntity(createOrUpdateSubjectDto);
        return subjectConverter.convertToSubjectDetailsDto(subjectRepository.save(subjectEntity));
    }

    @Override
    public List<SubjectDetailsDto> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectConverter::convertToSubjectDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDetailsDto getSubjectById(Long subjectId) {
        Optional<SubjectEntity> subjectEntityOptional = subjectRepository.findById(subjectId);

        return subjectEntityOptional
                .map(subjectConverter::convertToSubjectDetailsDto)
                .orElseThrow(() -> new SubjectNotFoundException(String.format(ErrorMessages.SUBJECT_NOT_FOUND, subjectId)));

    }
}