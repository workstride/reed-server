package com.works.reed.domain.course.dao;

import com.works.reed.domain.course.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
