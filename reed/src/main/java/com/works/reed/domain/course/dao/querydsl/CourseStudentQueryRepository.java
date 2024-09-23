package com.works.reed.domain.course.dao.querydsl;

import com.works.reed.domain.course.dto.CourseStudent;

import java.util.Optional;

public interface CourseStudentQueryRepository {
    Optional<CourseStudent> findCourseStudent(Long courseId, Long memberId);
}
