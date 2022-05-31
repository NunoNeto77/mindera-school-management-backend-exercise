package com.nunoneto.minderaSchool.service.teacher;

import com.nunoneto.minderaSchool.converter.TeacherConverter;
import com.nunoneto.minderaSchool.dto.teacher.CreateOrUpdateTeacherDto;
import com.nunoneto.minderaSchool.dto.teacher.TeacherDetailsDto;
import com.nunoneto.minderaSchool.entity.TeacherEntity;
import com.nunoneto.minderaSchool.exception.ErrorMessages;
import com.nunoneto.minderaSchool.exception.exceptions.TeacherNotFoundException;
import com.nunoneto.minderaSchool.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherConverter teacherConverter;
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDetailsDto createTeacher(CreateOrUpdateTeacherDto createOrUpdateTeacherDto) {
        TeacherEntity teacherEntity = teacherConverter.convertToEntity(createOrUpdateTeacherDto);
        return teacherConverter.convertToTeacherDetailsDto(teacherRepository.save(teacherEntity));
    }

    @Override
    public List<TeacherDetailsDto> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherConverter::convertToTeacherDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDetailsDto getTeacherById(Long teacherId) {
        Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(teacherId);

        return teacherEntityOptional
                .map(teacherConverter::convertToTeacherDetailsDto)
                .orElseThrow(() -> new TeacherNotFoundException(String.format(ErrorMessages.TEACHER_NOT_FOUND, teacherId)));

    }

    @Override
    public TeacherDetailsDto updateTeacherById(Long teacherId, CreateOrUpdateTeacherDto createOrUpdateTeacherDto) {
        Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(teacherId);
        if (teacherEntityOptional.isPresent()) {
            TeacherEntity teacher = teacherConverter.convertToEntity(createOrUpdateTeacherDto);
            teacher.setTeacherId(teacherId);
            return teacherConverter.convertToTeacherDetailsDto(teacherRepository.save(teacher));
        }
        throw new TeacherNotFoundException(String.format(ErrorMessages.TEACHER_NOT_FOUND, teacherId));
    }
}
