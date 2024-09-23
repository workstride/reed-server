package com.works.reed.domain.course.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCourseScheduleEntity is a Querydsl query type for CourseScheduleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourseScheduleEntity extends EntityPathBase<CourseScheduleEntity> {

    private static final long serialVersionUID = 599049427L;

    public static final QCourseScheduleEntity courseScheduleEntity = new QCourseScheduleEntity("courseScheduleEntity");

    public final NumberPath<Long> courseId = createNumber("courseId", Long.class);

    public final EnumPath<com.works.reed.domain.course.enums.DayOfWeek> dayOfWeek = createEnum("dayOfWeek", com.works.reed.domain.course.enums.DayOfWeek.class);

    public final TimePath<java.time.LocalTime> endTime = createTime("endTime", java.time.LocalTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TimePath<java.time.LocalTime> startTime = createTime("startTime", java.time.LocalTime.class);

    public QCourseScheduleEntity(String variable) {
        super(CourseScheduleEntity.class, forVariable(variable));
    }

    public QCourseScheduleEntity(Path<? extends CourseScheduleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourseScheduleEntity(PathMetadata metadata) {
        super(CourseScheduleEntity.class, metadata);
    }

}

