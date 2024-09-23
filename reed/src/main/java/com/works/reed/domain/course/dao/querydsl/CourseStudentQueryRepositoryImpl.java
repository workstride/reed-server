package com.works.reed.domain.course.dao.querydsl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.academy.dto.AcadStudent;
import com.works.reed.domain.course.dto.CourseStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.works.reed.domain.course.domain.QCourseStudentEntity.courseStudentEntity;

@Repository
@RequiredArgsConstructor
public class CourseStudentQueryRepositoryImpl implements CourseStudentQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<CourseStudent> findCourseStudent(Long courseId, Long memberId) {
        return Optional.of(queryFactory
                .select(courseStudentProjection())
                .from(courseStudentEntity)
                .where(
                        courseStudentEntity.courseId.eq(courseId),
                        courseStudentEntity.acadMemberId.memberId.eq(memberId)
                )
                .fetchOne());
    }

    private ConstructorExpression<CourseStudent> courseStudentProjection() {
        return Projections.constructor(
                CourseStudent.class,
                courseStudentEntity.id,
                Projections.constructor(AcadStudent.class, courseStudentEntity.acadMemberId.academyId, courseStudentEntity.acadMemberId.memberId),
                courseStudentEntity.courseId
        );
    }
}
