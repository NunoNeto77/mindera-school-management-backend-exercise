package com.nunoneto.minderaSchool.util;

public class LoggerMessages {

    private LoggerMessages() {
    }

    // information about type of request
    public static final String POST_REQUEST = "Request received to create {} at {}";
    public static final String GET_REQUEST = "Request received to get {} at {}";
    public static final String GET_ALL_REQUEST = "Request received to get all {} at {}";
    public static final String PUT_REQUEST = "Request received to update {} at {}";
    public static final String DELETE_REQUEST = "Request received to delete {} at {}";

    // specify the target entity of the request
    public static final String STUDENT = "user";
    public static final String SUBJECT = "subject";
    public static final String TEACHER = "teacher";
}