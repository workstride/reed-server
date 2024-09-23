package com.works.reed.domain.student.dao;


import com.works.reed.domain.student.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
