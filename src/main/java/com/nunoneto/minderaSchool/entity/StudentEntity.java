package com.nunoneto.minderaSchool.entity;

import com.nunoneto.minderaSchool.enumerator.UserType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_id_generator"
    )
    @SequenceGenerator(
            name = "students_id_generator",
            allocationSize = 1,
            sequenceName = "students_id_generator"
    )
    private Long studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private int studentAge;

    @Column(nullable = false, unique = true)
    private String studentEmail;

    @Column(nullable = false)
    private String studentPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType studentType;

}