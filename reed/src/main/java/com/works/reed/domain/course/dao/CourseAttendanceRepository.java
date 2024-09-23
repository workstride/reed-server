package com.works.reed.domain.course.dao;

import com.works.reed.domain.course.domain.CourseAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseAttendanceRepository extends JpaRepository<CourseAttendanceEntity, String> {
}
