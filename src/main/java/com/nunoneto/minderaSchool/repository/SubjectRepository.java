package com.nunoneto.minderaSchool.repository;


import com.nunoneto.minderaSchool.entity.StudentEntity;
import com.nunoneto.minderaSchool.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
