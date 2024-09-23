package com.works.reed.domain.teacher.dao;

import com.works.reed.domain.teacher.domain.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

}
