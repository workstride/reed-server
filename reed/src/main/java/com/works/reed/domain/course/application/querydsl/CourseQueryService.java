package com.works.reed.domain.course.application.querydsl;

import com.works.reed.domain.course.dto.CourseInfo;
import com.works.reed.domain.course.dto.request.CoursePageRequest;
import com.works.reed.domain.course.dto.response.CourseTodaySchedule;
import com.works.reed.global.common.dto.response.PageResponse;

import java.util.List;

public interface CourseQueryService {
    PageResponse<List<CourseInfo>> findCoursesByAcademyId(CoursePageRequest request);

    List<CourseTodaySchedule> findCoursesByMemberId();
}
