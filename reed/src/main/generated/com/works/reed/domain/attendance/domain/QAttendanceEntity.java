package com.works.reed.domain.attendance.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttendanceEntity is a Querydsl query type for AttendanceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendanceEntity extends EntityPathBase<AttendanceEntity> {

    private static final long serialVersionUID = 259037944L;

    public static final QAttendanceEntity attendanceEntity = new QAttendanceEntity("attendanceEntity");

    public final NumberPath<Long> courseStudentId = createNumber("courseStudentId", Long.class);

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TimePath<java.time.LocalTime> time = createTime("time", java.time.LocalTime.class);

    public QAttendanceEntity(String variable) {
        super(AttendanceEntity.class, forVariable(variable));
    }

    public QAttendanceEntity(Path<? extends AttendanceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttendanceEntity(PathMetadata metadata) {
        super(AttendanceEntity.class, metadata);
    }

}

