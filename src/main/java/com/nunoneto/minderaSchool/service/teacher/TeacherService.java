package com.nunoneto.minderaSchool.service.teacher;

import com.nunoneto.minderaSchool.dto.teacher.CreateOrUpdateTeacherDto;
import com.nunoneto.minderaSchool.dto.teacher.TeacherDetailsDto;

import java.util.List;

public interface TeacherService {

    TeacherDetailsDto createTeacher(CreateOrUpdateTeacherDto createOrUpdateTeacherDto);

    List<TeacherDetailsDto> getAllTeachers();

    TeacherDetailsDto getTeacherById(Long teacherId);

    TeacherDetailsDto updateTeacherById(Long teacherId, CreateOrUpdateTeacherDto createOrUpdateTeacherDto);
}
