package com.nunoneto.minderaSchool.service.student;

import com.nunoneto.minderaSchool.dto.student.CreateOrUpdateStudentDto;
import com.nunoneto.minderaSchool.dto.student.StudentDetailsDto;

import java.util.List;

public interface StudentService {

    StudentDetailsDto createStudent(CreateOrUpdateStudentDto createOrUpdateStudentDtoDto);

    List<StudentDetailsDto> getAllStudents();

    StudentDetailsDto getStudentById(Long studentId);

    StudentDetailsDto updateStudentById(Long studentId, CreateOrUpdateStudentDto createOrUpdateStudentDto);
}