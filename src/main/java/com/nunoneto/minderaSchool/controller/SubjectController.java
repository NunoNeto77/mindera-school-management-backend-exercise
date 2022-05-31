package com.nunoneto.minderaSchool.controller;

import com.nunoneto.minderaSchool.dto.subject.CreateOrUpdateSubjectDto;
import com.nunoneto.minderaSchool.dto.subject.SubjectDetailsDto;
import com.nunoneto.minderaSchool.service.subject.SubjectService;
import com.nunoneto.minderaSchool.service.subject.SubjectServiceImpl;
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
public class SubjectController {

    private final SubjectServiceImpl subjectService;

   @PostMapping("/subjects")
   public ResponseEntity<SubjectDetailsDto> createSubject(@RequestBody CreateOrUpdateSubjectDto subjectDto) {
       log.info(LoggerMessages.POST_REQUEST, LoggerMessages.SUBJECT, LocalDate.now());
       return ResponseEntity.ok(subjectService.createSubject(subjectDto));
    }

    @GetMapping("subjects")
    public ResponseEntity<List<SubjectDetailsDto>> getAllSubjects() {
        log.info(LoggerMessages.GET_ALL_REQUEST, LoggerMessages.SUBJECT, LocalDate.now());
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("subjects/{subjectId}")
    public ResponseEntity<SubjectDetailsDto> getSubjectById(@PathVariable Long subjectId) {
        log.info(LoggerMessages.GET_REQUEST, LoggerMessages.SUBJECT, LocalDate.now());
        return ResponseEntity.ok(subjectService.getSubjectById(subjectId));
    }
}
