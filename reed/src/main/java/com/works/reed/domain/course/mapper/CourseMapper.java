package com.works.reed.domain.course.mapper;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.domain.course.domain.CourseEntity;
import com.works.reed.domain.course.domain.CourseScheduleEntity;
import com.works.reed.domain.course.domain.CourseStudentEntity;
import com.works.reed.domain.course.dto.Course;
import com.works.reed.domain.course.dto.CourseSchedule;
import com.works.reed.domain.course.dto.CourseStudent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseEntity createCourse(Course course) {

        return CourseEntity.builder()
                .id(course.getId())
                .acadMemberId(
                        AcadMemberId.builder()
                                .memberId(course.getAcademyTeacher().getMemberId())
                                .academyId(course.getAcademyTeacher().getAcademyId())
                                .build()
                )
                .name(course.getName())
                .room(course.getRoom())
                .maxCnt(course.getMaxCnt())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .build();
    }

    public List<CourseScheduleEntity> createCourseSchedulesWithCsno(final Long courseId, List<CourseSchedule> courseSchedules) {
        return courseSchedules.stream().peek(csh -> csh.setCourseId(courseId)).map(this::createCourseSchedule).collect(Collectors.toList());
    }

    public CourseScheduleEntity createCourseSchedule(CourseSchedule dto) {
        return CourseScheduleEntity.builder()
                .id(dto.getId())
                .courseId(dto.getCourseId())
                .dayOfWeek(dto.getDayOfWeek())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .build();
    }

    public CourseStudentEntity createCourseStudent(CourseStudent dto) {
        return CourseStudentEntity.builder()
                .id(dto.getId())
                .acadMemberId(
                        AcadMemberId.builder()
                                .academyId(dto.getAcademyStudent().getAcademyId())
                                .memberId(dto.getAcademyStudent().getMemberId())
                                .build()
                )
                .courseId(dto.getCourseId())
                .build();
    }

    public CourseSchedule toCourseSchedule(CourseScheduleEntity courseScheduleEntity) {
        return CourseSchedule.builder()
                .id(courseScheduleEntity.getId())
                .courseId(courseScheduleEntity.getCourseId())
                .dayOfWeek(courseScheduleEntity.getDayOfWeek())
                .startTime(courseScheduleEntity.getStartTime())
                .endTime(courseScheduleEntity.getEndTime())
                .build();
    }

}
