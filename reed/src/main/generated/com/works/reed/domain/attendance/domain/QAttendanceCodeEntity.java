package com.works.reed.domain.attendance.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAttendanceCodeEntity is a Querydsl query type for AttendanceCodeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendanceCodeEntity extends EntityPathBase<AttendanceCodeEntity> {

    private static final long serialVersionUID = 1755823301L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttendanceCodeEntity attendanceCodeEntity = new QAttendanceCodeEntity("attendanceCodeEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.academy.domain.id.QAcadMemberId acadMemberId;

    public final BooleanPath active = createBoolean("active");

    public final StringPath code = createString("code");

    public final NumberPath<Long> courseId = createNumber("courseId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QAttendanceCodeEntity(String variable) {
        this(AttendanceCodeEntity.class, forVariable(variable), INITS);
    }

    public QAttendanceCodeEntity(Path<? extends AttendanceCodeEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAttendanceCodeEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAttendanceCodeEntity(PathMetadata metadata, PathInits inits) {
        this(AttendanceCodeEntity.class, metadata, inits);
    }

    public QAttendanceCodeEntity(Class<? extends AttendanceCodeEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acadMemberId = inits.isInitialized("acadMemberId") ? new com.works.reed.domain.academy.domain.id.QAcadMemberId(forProperty("acadMemberId")) : null;
    }

}

