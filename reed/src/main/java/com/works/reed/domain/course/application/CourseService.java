package com.works.reed.domain.course.application;

import com.works.reed.domain.course.dto.Course;
import com.works.reed.domain.course.dto.CourseSchedule;
import com.works.reed.domain.course.dto.CourseStudent;
import com.works.reed.domain.course.dto.response.CourseAttendanceInfo;

import java.util.List;

public interface CourseService {
    void register(Course course, List<CourseSchedule> courseSchedules);

    void remove(Long courseId);

    void registerCourses(CourseStudent courseStudent);

    List<CourseAttendanceInfo> findCourseAttendanceInfo(Long courseId);

    void attendance(Long memberId);
}
