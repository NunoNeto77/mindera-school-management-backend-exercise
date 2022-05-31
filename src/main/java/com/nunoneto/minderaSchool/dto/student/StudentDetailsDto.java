package com.nunoneto.minderaSchool.dto.student;

import com.nunoneto.minderaSchool.enumerator.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDetailsDto {

    private Long studentId;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentPassword;
    private UserType studentType;
}