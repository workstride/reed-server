package com.works.reed.domain.course.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourseStudentEntity is a Querydsl query type for CourseStudentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourseStudentEntity extends EntityPathBase<CourseStudentEntity> {

    private static final long serialVersionUID = 82524005L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourseStudentEntity courseStudentEntity = new QCourseStudentEntity("courseStudentEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.academy.domain.id.QAcadMemberId acadMemberId;

    public final NumberPath<Long> courseId = createNumber("courseId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QCourseStudentEntity(String variable) {
        this(CourseStudentEntity.class, forVariable(variable), INITS);
    }

    public QCourseStudentEntity(Path<? extends CourseStudentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourseStudentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourseStudentEntity(PathMetadata metadata, PathInits inits) {
        this(CourseStudentEntity.class, metadata, inits);
    }

    public QCourseStudentEntity(Class<? extends CourseStudentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acadMemberId = inits.isInitialized("acadMemberId") ? new com.works.reed.domain.academy.domain.id.QAcadMemberId(forProperty("acadMemberId")) : null;
    }

}

