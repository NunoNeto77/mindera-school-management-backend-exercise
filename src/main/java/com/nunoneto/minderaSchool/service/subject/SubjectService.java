package com.nunoneto.minderaSchool.service.subject;

import com.nunoneto.minderaSchool.dto.student.CreateOrUpdateStudentDto;
import com.nunoneto.minderaSchool.dto.student.StudentDetailsDto;
import com.nunoneto.minderaSchool.dto.subject.CreateOrUpdateSubjectDto;
import com.nunoneto.minderaSchool.dto.subject.SubjectDetailsDto;

import java.util.List;

public interface SubjectService {

    SubjectDetailsDto createSubject(CreateOrUpdateSubjectDto createOrUpdateSubjectDto);

    List<SubjectDetailsDto> getAllSubjects();

    SubjectDetailsDto getSubjectById(Long subjectId);

}