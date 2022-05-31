package com.nunoneto.minderaSchool.exception.exceptions;

import com.nunoneto.minderaSchool.exception.MinderaSchoolException;

public class StudentNotFoundException extends MinderaSchoolException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}