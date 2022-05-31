package com.nunoneto.minderaSchool.dto.subject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectDetailsDto {

    private Long subjectId;
    private String subjectName;
}
