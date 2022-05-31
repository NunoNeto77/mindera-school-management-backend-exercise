package com.nunoneto.minderaSchool.converter;

import com.nunoneto.minderaSchool.dto.teacher.CreateOrUpdateTeacherDto;
import com.nunoneto.minderaSchool.dto.teacher.TeacherDetailsDto;
import com.nunoneto.minderaSchool.entity.TeacherEntity;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter {

    public TeacherEntity convertToEntity(CreateOrUpdateTeacherDto dto) {
        return TeacherEntity.builder()
                .teacherName(dto.getTeacherName())
                .teacherAge(dto.getTeacherAge())
                .teacherEmail(dto.getTeacherEmail())
                .teacherPassword(dto.getTeacherPassword())
                .teacherType(dto.getTeacherType())
                .build();
    }

    public TeacherDetailsDto convertToTeacherDetailsDto(TeacherEntity entity) {
        return TeacherDetailsDto.builder()
                .teacherId(entity.getTeacherId())
                .teacherName(entity.getTeacherName())
                .teacherEmail(entity.getTeacherEmail())
                .teacherAge(entity.getTeacherAge())
                .teacherPassword(entity.getTeacherPassword())
                .teacherType(entity.getTeacherType())
                .build();
    }
}