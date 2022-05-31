package com.nunoneto.minderaSchool.dto.student;

import com.nunoneto.minderaSchool.enumerator.UserType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrUpdateStudentDto {

    @NotNull
    private String studentName;

    @NotNull
    private int studentAge;

    @NotNull
    private String studentEmail;

    @NotNull
    private String studentPassword;

    @NotNull
    private UserType studentType;
}