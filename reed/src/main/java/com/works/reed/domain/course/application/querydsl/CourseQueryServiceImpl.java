package com.works.reed.domain.course.application.querydsl;

import com.works.reed.domain.course.dao.querydsl.CourseQueryRepository;
import com.works.reed.domain.course.dto.CourseInfo;
import com.works.reed.domain.course.dto.request.CoursePageRequest;
import com.works.reed.domain.course.dto.response.CourseTodaySchedule;
import com.works.reed.global.common.dao.MemberSecurity;
import com.works.reed.global.common.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class CourseQueryServiceImpl implements CourseQueryService {

    private final CourseQueryRepository courseQueryRepository;
    private final MemberSecurity memberSecurity;

    public PageResponse<List<CourseInfo>> findCoursesByAcademyId(CoursePageRequest request) {
        List<CourseInfo> result = courseQueryRepository.findCoursesByAcademyId(request);
        return new PageResponse<List<CourseInfo>>(result, result.size());
    }

    public List<CourseTodaySchedule> findCoursesByMemberId() {
        return courseQueryRepository.findCoursesByMemberId(memberSecurity.getMember().getId());
    }

}
