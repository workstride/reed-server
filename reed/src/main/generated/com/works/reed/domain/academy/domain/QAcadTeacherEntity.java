package com.works.reed.domain.academy.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAcadTeacherEntity is a Querydsl query type for AcadTeacherEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAcadTeacherEntity extends EntityPathBase<AcadTeacherEntity> {

    private static final long serialVersionUID = -346269409L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAcadTeacherEntity acadTeacherEntity = new QAcadTeacherEntity("acadTeacherEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.academy.domain.id.QAcadMemberId acadMemberId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QAcadTeacherEntity(String variable) {
        this(AcadTeacherEntity.class, forVariable(variable), INITS);
    }

    public QAcadTeacherEntity(Path<? extends AcadTeacherEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAcadTeacherEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAcadTeacherEntity(PathMetadata metadata, PathInits inits) {
        this(AcadTeacherEntity.class, metadata, inits);
    }

    public QAcadTeacherEntity(Class<? extends AcadTeacherEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acadMemberId = inits.isInitialized("acadMemberId") ? new com.works.reed.domain.academy.domain.id.QAcadMemberId(forProperty("acadMemberId")) : null;
    }

}

