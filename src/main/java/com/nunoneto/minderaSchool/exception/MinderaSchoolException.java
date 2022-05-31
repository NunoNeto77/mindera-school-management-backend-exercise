package com.nunoneto.minderaSchool.exception;

public abstract class MinderaSchoolException extends RuntimeException {

    public MinderaSchoolException() {
    }

    public MinderaSchoolException(String message) {
        super(message);
    }

    public MinderaSchoolException(String message, Throwable cause) {
        super(message, cause);
    }
}
