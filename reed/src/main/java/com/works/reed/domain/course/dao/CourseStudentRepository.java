package com.works.reed.domain.course.dao;

import com.works.reed.domain.course.domain.CourseStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudentEntity, Long> {


}
