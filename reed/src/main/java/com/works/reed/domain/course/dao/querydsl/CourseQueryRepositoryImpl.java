package com.works.reed.domain.course.dao.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.course.dto.CourseInfo;
import com.works.reed.domain.course.dto.CourseScheduleInfo;
import com.works.reed.domain.course.dto.request.CoursePageRequest;
import com.works.reed.domain.course.dto.response.CourseTodaySchedule;
import com.works.reed.domain.course.enums.DayOfWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.works.reed.domain.academy.domain.QAcadTeacherEntity.acadTeacherEntity;
import static com.works.reed.domain.course.domain.QCourseEntity.courseEntity;
import static com.works.reed.domain.course.domain.QCourseScheduleEntity.courseScheduleEntity;
import static com.works.reed.domain.course.domain.QCourseStudentEntity.courseStudentEntity;
import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class CourseQueryRepositoryImpl implements CourseQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<CourseTodaySchedule> findCoursesByMemberId(Long memberId) {
        return queryFactory
                .select(courseTodayScheduleProjection())
                .from(courseStudentEntity)
                .innerJoin(courseEntity).on(courseStudentEntity.courseId.eq(courseEntity.id))
                .innerJoin(courseScheduleEntity).on(courseEntity.id.eq(courseScheduleEntity.courseId))
                .where(
                        courseStudentEntity.acadMemberId.memberId.eq(memberId),
                        courseScheduleEntity.dayOfWeek.eq(DayOfWeek.values()[LocalDate.now().getDayOfWeek().getValue() - 1])
                )
                .orderBy(courseScheduleEntity.startTime.asc(), courseScheduleEntity.endTime.asc())
                .fetch();
    }

    public List<CourseInfo> findCoursesByAcademyId(CoursePageRequest request) {
        return queryFactory
                .from(courseEntity)
                .innerJoin(courseScheduleEntity).on(courseEntity.id.eq(courseScheduleEntity.courseId))
                .innerJoin(acadTeacherEntity).on(acadTeacherEntity.acadMemberId.eq(courseEntity.acadMemberId))
                .innerJoin(memberEntity).on(memberEntity.id.eq(acadTeacherEntity.acadMemberId.memberId))
                .where(courseEntity.acadMemberId.academyId.eq(request.getAcademyId()))
                .orderBy(courseEntity.id.desc())
                .transform(groupBy(courseScheduleEntity.courseId).list(
                        Projections.fields(
                                CourseInfo.class,
                                courseScheduleEntity.courseId.as("courseId"),
                                courseEntity.acadMemberId.memberId,
                                courseEntity.acadMemberId.academyId,
                                courseEntity.name,
                                courseEntity.room,
                                courseEntity.maxCnt,
                                courseEntity.startDate,
                                courseEntity.endDate,
                                memberEntity.email.as("teacherEmail"),
                                memberEntity.name.as("teacherName"),
                                memberEntity.tel.as("teacherTel"),
                                list(
                                        Projections.constructor(
                                                CourseScheduleInfo.class,
                                                courseScheduleEntity.id,
                                                courseScheduleEntity.courseId,
                                                courseScheduleEntity.dayOfWeek,
                                                courseScheduleEntity.startTime,
                                                courseScheduleEntity.endTime
                                        )
                                ).as("schedules")
                        )
                ));
    }

    private ConstructorExpression<CourseTodaySchedule> courseTodayScheduleProjection() {
        return Projections.constructor(
                CourseTodaySchedule.class,
                courseEntity.id,
                courseEntity.name,
                courseEntity.room,
                courseScheduleEntity.dayOfWeek,
                courseScheduleEntity.startTime,
                courseScheduleEntity.endTime
        );
    }

    private ConstructorExpression<CourseInfo> courseInfoProjection() {
        return Projections.constructor(
                CourseInfo.class,
                courseScheduleEntity.courseId,
                courseEntity.acadMemberId.memberId,
                courseEntity.acadMemberId.academyId,
                courseEntity.name,
                courseEntity.room,
                courseEntity.maxCnt,
                courseEntity.startDate,
                courseEntity.endDate,
                list(
                        Projections.constructor(
                                CourseScheduleInfo.class,
                                courseScheduleEntity.id,
                                courseScheduleEntity.dayOfWeek,
                                courseScheduleEntity.startTime,
                                courseScheduleEntity.endTime
                        )
                ).as("schedules")
        );
    }

    private BooleanBuilder search(String type, String keyword) {

        if (!hasText(type))
            return null;

        String[] typeArr = type.split("");
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        for (String t : typeArr) {
            switch (t) {
                case "n":
                    conditionBuilder.or(memberEntity.name.contains(keyword));
                    break;
                case "e":
                    conditionBuilder.or(memberEntity.email.contains(keyword));
                    break;
            }
        }
        return conditionBuilder;
    }

}
