package com.nunoneto.minderaSchool.dto.teacher;

import com.nunoneto.minderaSchool.enumerator.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDetailsDto {

    private Long teacherId;
    private String teacherName;
    private int teacherAge;
    private String teacherEmail;
    private String teacherPassword;
    private String profession;
    private UserType teacherType;
}