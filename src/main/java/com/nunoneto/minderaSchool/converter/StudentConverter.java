package com.nunoneto.minderaSchool.converter;

import com.nunoneto.minderaSchool.dto.student.CreateOrUpdateStudentDto;
import com.nunoneto.minderaSchool.dto.student.StudentDetailsDto;
import com.nunoneto.minderaSchool.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentEntity convertToEntity(CreateOrUpdateStudentDto dto) {
        return StudentEntity.builder()
                .studentName(dto.getStudentName())
                .studentAge(dto.getStudentAge())
                .studentEmail(dto.getStudentEmail())
                .studentPassword(dto.getStudentPassword())
                .studentType(dto.getStudentType())
                .build();
    }

    public StudentDetailsDto convertToStudentDetailsDto(StudentEntity entity) {
        return StudentDetailsDto.builder()
                .studentId(entity.getStudentId())
                .studentName(entity.getStudentName())
                .studentEmail(entity.getStudentEmail())
                .studentAge(entity.getStudentAge())
                .studentPassword(entity.getStudentPassword())
                .studentType(entity.getStudentType())
                .build();
    }
}