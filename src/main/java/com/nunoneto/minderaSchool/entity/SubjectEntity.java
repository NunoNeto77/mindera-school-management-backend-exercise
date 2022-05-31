package com.nunoneto.minderaSchool.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subjects_id_generator"
    )
    @SequenceGenerator(
            name = "subjects_id_generator",
            allocationSize = 1,
            sequenceName = "subjects_id_generator"
    )
    private Long subjectId;

    @Column(nullable = false)
    private String subjectName;
}