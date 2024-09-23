package com.works.reed.domain.course.dao;

import com.works.reed.domain.course.domain.CourseStudentEntity;
import com.works.reed.domain.course.dto.request.CourseStudRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseStudRegisterRepository extends JpaRepository<CourseStudentEntity, Long> {
    List<CourseStudRegisterRequest> findAllByCourseId(Long courseId);
}
