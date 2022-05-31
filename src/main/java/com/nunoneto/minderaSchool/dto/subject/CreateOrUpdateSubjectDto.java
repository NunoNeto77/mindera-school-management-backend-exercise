package com.nunoneto.minderaSchool.dto.subject;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrUpdateSubjectDto {

    @NotNull
    private String subjectName;
}