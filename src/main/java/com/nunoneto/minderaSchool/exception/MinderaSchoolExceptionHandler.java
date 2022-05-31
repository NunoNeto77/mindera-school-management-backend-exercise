package com.nunoneto.minderaSchool.exception;

import com.nunoneto.minderaSchool.exception.exceptions.StudentNotFoundException;
import com.nunoneto.minderaSchool.exception.exceptions.SubjectNotFoundException;
import com.nunoneto.minderaSchool.exception.exceptions.TeacherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MinderaSchoolExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<MinderaSchoolError> handleStudentNotFoundException(Exception ex, HttpServletRequest req) {
        MinderaSchoolError error = MinderaSchoolError.builder()
                .message(ex.getMessage())
                .exception(ex.getClass().getSimpleName())
                .path(req.getRequestURI())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {SubjectNotFoundException.class})
    public ResponseEntity<MinderaSchoolError> handleSubjectNotFoundException(Exception ex, HttpServletRequest req) {
        MinderaSchoolError error = MinderaSchoolError.builder()
                .message(ex.getMessage())
                .exception(ex.getClass().getSimpleName())
                .path(req.getRequestURI())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(value = {TeacherNotFoundException.class})
    public ResponseEntity<MinderaSchoolError> handlerTeacherNotFoundException(Exception ex, HttpServletRequest req) {
        MinderaSchoolError error = MinderaSchoolError.builder()
                .message(ex.getMessage())
                .exception(ex.getClass().getSimpleName())
                .path(req.getRequestURI())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}