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
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teachers_id_generator"
    )
    @SequenceGenerator(
            name = "teachers_id_generator",
            allocationSize = 1,
            sequenceName = "teachers_id_generator"
    )
    private Long teacherId;

    @Column(nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private int teacherAge;

    @Column(nullable = false, unique = true)
    private String teacherEmail;

    @Column(nullable = false)
    private String teacherPassword;

    @Column(nullable = false)
    private String profession;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType teacherType;
}
