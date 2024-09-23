package com.works.reed.domain.course.dao;

import com.works.reed.domain.course.domain.CourseScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseScheduleRepository extends JpaRepository<CourseScheduleEntity, Long> {

    Optional<List<CourseScheduleEntity>> findByCourseId(Long courseId);

}
