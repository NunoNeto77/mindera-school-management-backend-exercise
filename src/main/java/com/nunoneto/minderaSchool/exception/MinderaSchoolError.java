package com.nunoneto.minderaSchool.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MinderaSchoolError {

    private String message;
    private String exception;
    private String path;
}
