package com.works.reed.domain.course.api;

import com.works.reed.domain.course.application.CourseService;
import com.works.reed.domain.course.application.querydsl.CourseQueryService;
import com.works.reed.domain.course.dto.CourseInfo;
import com.works.reed.domain.course.dto.request.CoursePageRequest;
import com.works.reed.domain.course.dto.request.CourseRegisterRequest;
import com.works.reed.domain.course.dto.request.CourseStudRegisterRequest;
//import com.works.reed.domain.course.dto.response.CourseAttendanceInfo;
import com.works.reed.domain.course.dto.response.CourseAttendanceInfo;
import com.works.reed.domain.course.dto.response.CourseTodaySchedule;
import com.works.reed.global.common.dto.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "수업", description = "수업")
@SecurityRequirement(name = "BearerAuthentication")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService service;
    private final CourseQueryService courseQueryService;

    @Operation(summary = "수업 등록", description = "수업 등록")
    @PreAuthorize("hasRole('ROLE_HEAD_TEACHER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody CourseRegisterRequest request) {
        service.register(request.toCourseDTO(), request.toCourseSchedules());
    }

    @Operation(summary = "수업 삭제", description = "수업 삭제")
    @PreAuthorize("hasRole('ROLE_HEAD_TEACHER')")
    @DeleteMapping("/{courseId}")
    public void remove(@PathVariable("courseId") Long courseId) {
        service.remove(courseId);
    }

    @Operation(summary = "수업 조회", description = "수업 조회")
    @PreAuthorize("hasAnyRole('ROLE_HEAD_TEACHER', 'ROLE_TEACHER')")
    @GetMapping("/list")
    public PageResponse<List<CourseInfo>> findCoursesByAcademyId(@Validated @ModelAttribute CoursePageRequest request) {
        return courseQueryService.findCoursesByAcademyId(request);
    }

    @Operation(summary = "수업(강의) 신청", description = "수업(강의) 신청")
    @PreAuthorize("hasRole('ROLE_HEAD_TEACHER')")
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCourses(@Validated @RequestBody CourseStudRegisterRequest request) {
        service.registerCourses(request.toCourseStudent());
    }

    @Operation(summary = "오늘 수업(강의)", description = "오늘 수업(강의)")
    @GetMapping("/schedules")
    public List<CourseTodaySchedule> findCoursesByMemberId() {
        return courseQueryService.findCoursesByMemberId();
    }

    @Operation(summary = "수업 출석 현황", description = "수업 출석 현황")
    @GetMapping("/{courseId}")
    public List<CourseAttendanceInfo> findAttendanceByCourseId(@PathVariable("courseId") Long courseId) {
        return service.findCourseAttendanceInfo(courseId);
    }

}
