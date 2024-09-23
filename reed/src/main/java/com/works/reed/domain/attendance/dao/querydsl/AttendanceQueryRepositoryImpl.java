package com.works.reed.domain.attendance.dao.querydsl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.attendance.dto.NonAttendance;
import com.works.reed.domain.course.enums.DayOfWeek;
import com.works.reed.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.works.reed.domain.attendance.domain.QAttendanceEntity.attendanceEntity;
import static com.works.reed.domain.course.domain.QCourseEntity.courseEntity;
import static com.works.reed.domain.course.domain.QCourseScheduleEntity.courseScheduleEntity;
import static com.works.reed.domain.course.domain.QCourseStudentEntity.courseStudentEntity;
import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;

@Repository
@RequiredArgsConstructor
public class AttendanceQueryRepositoryImpl implements AttendanceQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<NonAttendance> findNonAttendance(PageRequest request) {

        return queryFactory
                .select(nonAttendanceSearchInfoProjection())
                .from(courseEntity)
                .innerJoin(courseScheduleEntity).on(courseEntity.id.eq(courseScheduleEntity.courseId))
                .innerJoin(courseStudentEntity).on(courseEntity.id.eq(courseStudentEntity.courseId))
                .innerJoin(memberEntity).on(courseStudentEntity.acadMemberId.memberId.eq(memberEntity.id))
                .leftJoin(attendanceEntity).on(
                        courseStudentEntity.id
                                .eq(attendanceEntity.courseStudentId)
                                .and(attendanceEntity.date.eq(LocalDate.now()))
                                .and(attendanceEntity.time.between(LocalTime.now().minusMinutes(30), LocalTime.now()))
                )
                .where(
                        courseEntity.startDate.loe(LocalDateTime.now()),
                        courseEntity.endDate.isNull().or(courseEntity.endDate.goe(LocalDateTime.now())),
                        eqDayOfWeek(),
                        courseScheduleEntity.startTime.between(LocalTime.now().minusMinutes(10).truncatedTo(ChronoUnit.MINUTES), LocalTime.now().truncatedTo(ChronoUnit.MINUTES).plusSeconds(59)),
                        attendanceEntity.courseStudentId.isNull()
                )
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(courseEntity.id.desc())
                .fetch();
    }

    private ConstructorExpression<NonAttendance> nonAttendanceSearchInfoProjection() {
        return Projections.constructor(
                NonAttendance.class,
                courseEntity.id,
                courseEntity.name,
                memberEntity.email,
                memberEntity.name,
                courseStudentEntity.acadMemberId.academyId,
                courseStudentEntity.acadMemberId.memberId,
                courseScheduleEntity.dayOfWeek,
                courseScheduleEntity.startTime,
                courseScheduleEntity.endTime
        );
    }

    private BooleanExpression eqDayOfWeek() {
        return courseScheduleEntity.dayOfWeek.eq(DayOfWeek.values()[LocalDate.now().getDayOfWeek().getValue() - 1]);
    }


}
