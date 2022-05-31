package com.nunoneto.minderaSchool.dto.teacher;

import com.nunoneto.minderaSchool.enumerator.UserType;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrUpdateTeacherDto {

    @NotNull
    private String teacherName;

    @NotNull
    private int teacherAge;

    @NotNull
    private String teacherEmail;

    @NotNull
    private String teacherPassword;

    @NotNull
    private UserType teacherType;
}
