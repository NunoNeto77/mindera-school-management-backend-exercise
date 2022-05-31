package com.nunoneto.minderaSchool.controller;

import com.nunoneto.minderaSchool.dto.student.CreateOrUpdateStudentDto;
import com.nunoneto.minderaSchool.dto.student.StudentDetailsDto;
import com.nunoneto.minderaSchool.service.student.StudentServiceImpl;
import com.nunoneto.minderaSchool.util.LoggerMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping()
    @PreAuthorize("hasRole('TEACHER')") // before to create a student, verify if the person who is trying to create is a teacher. If it is, it works, otherwise, does not work
    public ResponseEntity<StudentDetailsDto> createStudent(@RequestBody CreateOrUpdateStudentDto studentDto) {
        log.info(LoggerMessages.POST_REQUEST, LoggerMessages.STUDENT, LocalDate.now());
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }

    @GetMapping()
    public ResponseEntity<List<StudentDetailsDto>> getAllStudents() {
        log.info(LoggerMessages.GET_ALL_REQUEST, LoggerMessages.STUDENT, LocalDate.now());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDetailsDto> getStudentById(@PathVariable Long studentId) {
        log.info(LoggerMessages.GET_REQUEST, LoggerMessages.STUDENT, LocalDate.now());
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDetailsDto> updateStudentById(@PathVariable Long studentId, @RequestBody CreateOrUpdateStudentDto createOrUpdateStudentDto) {
        log.info(LoggerMessages.PUT_REQUEST, LoggerMessages.STUDENT, LocalDate.now());
        return ResponseEntity.ok(studentService.updateStudentById(studentId, createOrUpdateStudentDto));
    }
}