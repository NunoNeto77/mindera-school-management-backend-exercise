package com.nunoneto.minderaSchool.converter;

import com.nunoneto.minderaSchool.dto.subject.CreateOrUpdateSubjectDto;
import com.nunoneto.minderaSchool.dto.subject.SubjectDetailsDto;
import com.nunoneto.minderaSchool.entity.SubjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {

    public SubjectEntity convertToEntity(CreateOrUpdateSubjectDto dto) {
        return SubjectEntity.builder()
                .subjectName(dto.getSubjectName())
                .build();
    }

    public SubjectDetailsDto convertToSubjectDetailsDto(SubjectEntity entity) {
        return SubjectDetailsDto.builder()
                        .subjectId(entity.getSubjectId())
                                .subjectName(entity.getSubjectName())
                .build();
    }
}