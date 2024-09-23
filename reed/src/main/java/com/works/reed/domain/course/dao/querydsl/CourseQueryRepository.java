package com.works.reed.domain.course.dao.querydsl;

import com.works.reed.domain.course.dto.CourseInfo;
import com.works.reed.domain.course.dto.request.CoursePageRequest;
import com.works.reed.domain.course.dto.response.CourseTodaySchedule;

import java.util.List;

public interface CourseQueryRepository {
    List<CourseTodaySchedule> findCoursesByMemberId(Long memberId);

    List<CourseInfo> findCoursesByAcademyId(CoursePageRequest request);
}
