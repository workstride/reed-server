package com.works.reed.domain.academy.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAcademyEntity is a Querydsl query type for AcademyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAcademyEntity extends EntityPathBase<AcademyEntity> {

    private static final long serialVersionUID = 2083959790L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAcademyEntity academyEntity = new QAcademyEntity("academyEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.global.common.embed.QAddress address;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath tel = createString("tel");

    public QAcademyEntity(String variable) {
        this(AcademyEntity.class, forVariable(variable), INITS);
    }

    public QAcademyEntity(Path<? extends AcademyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAcademyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAcademyEntity(PathMetadata metadata, PathInits inits) {
        this(AcademyEntity.class, metadata, inits);
    }

    public QAcademyEntity(Class<? extends AcademyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.works.reed.global.common.embed.QAddress(forProperty("address")) : null;
    }

}

