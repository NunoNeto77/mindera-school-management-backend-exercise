package com.nunoneto.minderaSchool.controller;

import com.nunoneto.minderaSchool.dto.teacher.CreateOrUpdateTeacherDto;
import com.nunoneto.minderaSchool.dto.teacher.TeacherDetailsDto;
import com.nunoneto.minderaSchool.service.teacher.TeacherServiceImpl;
import com.nunoneto.minderaSchool.util.LoggerMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherServiceImpl  teacherService;

    @PostMapping("/teachers")
    public ResponseEntity<TeacherDetailsDto> createTeacher(@RequestBody CreateOrUpdateTeacherDto teacherDto) {
        log.info(LoggerMessages.POST_REQUEST, LoggerMessages.TEACHER, LocalDate.now());
        return ResponseEntity.ok(teacherService.createTeacher(teacherDto));
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDetailsDto>> getAllTeachers() {
        log.info(LoggerMessages.GET_ALL_REQUEST, LoggerMessages.TEACHER, LocalDate.now());
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("teachers/{teacherId}")
    public ResponseEntity<TeacherDetailsDto> getTeacherById(Long teacherId) {
        log.info(LoggerMessages.GET_REQUEST, LoggerMessages.TEACHER, LocalDate.now());
        return ResponseEntity.ok(teacherService.getTeacherById(teacherId));
    }

    @PutMapping("/teachers/{teacherId}")
    public ResponseEntity<TeacherDetailsDto> updateTeacherById(@PathVariable Long teacherId, @RequestBody CreateOrUpdateTeacherDto teacherDto) {
        log.info(LoggerMessages.PUT_REQUEST, LoggerMessages.TEACHER, LocalDate.now());
        return ResponseEntity.ok(teacherService.updateTeacherById(teacherId, teacherDto));
    }
}
