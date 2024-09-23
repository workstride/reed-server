package com.works.reed.domain.course.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourseEntity is a Querydsl query type for CourseEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourseEntity extends EntityPathBase<CourseEntity> {

    private static final long serialVersionUID = 1097948252L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCourseEntity courseEntity = new QCourseEntity("courseEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.academy.domain.id.QAcadMemberId acadMemberId;

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> maxCnt = createNumber("maxCnt", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath room = createString("room");

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public QCourseEntity(String variable) {
        this(CourseEntity.class, forVariable(variable), INITS);
    }

    public QCourseEntity(Path<? extends CourseEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCourseEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCourseEntity(PathMetadata metadata, PathInits inits) {
        this(CourseEntity.class, metadata, inits);
    }

    public QCourseEntity(Class<? extends CourseEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acadMemberId = inits.isInitialized("acadMemberId") ? new com.works.reed.domain.academy.domain.id.QAcadMemberId(forProperty("acadMemberId")) : null;
    }

}

