package com.works.reed.domain.academy.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAcadStudentEntity is a Querydsl query type for AcadStudentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAcadStudentEntity extends EntityPathBase<AcadStudentEntity> {

    private static final long serialVersionUID = 1515399352L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAcadStudentEntity acadStudentEntity = new QAcadStudentEntity("acadStudentEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.academy.domain.id.QAcadMemberId acadMemberId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QAcadStudentEntity(String variable) {
        this(AcadStudentEntity.class, forVariable(variable), INITS);
    }

    public QAcadStudentEntity(Path<? extends AcadStudentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAcadStudentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAcadStudentEntity(PathMetadata metadata, PathInits inits) {
        this(AcadStudentEntity.class, metadata, inits);
    }

    public QAcadStudentEntity(Class<? extends AcadStudentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.acadMemberId = inits.isInitialized("acadMemberId") ? new com.works.reed.domain.academy.domain.id.QAcadMemberId(forProperty("acadMemberId")) : null;
    }

}

