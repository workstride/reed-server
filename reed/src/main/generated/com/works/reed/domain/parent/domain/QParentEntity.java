package com.works.reed.domain.parent.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParentEntity is a Querydsl query type for ParentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParentEntity extends EntityPathBase<ParentEntity> {

    private static final long serialVersionUID = 1877731514L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParentEntity parentEntity = new QParentEntity("parentEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.parent.domain.id.QParentId id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QParentEntity(String variable) {
        this(ParentEntity.class, forVariable(variable), INITS);
    }

    public QParentEntity(Path<? extends ParentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParentEntity(PathMetadata metadata, PathInits inits) {
        this(ParentEntity.class, metadata, inits);
    }

    public QParentEntity(Class<? extends ParentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new com.works.reed.domain.parent.domain.id.QParentId(forProperty("id")) : null;
    }

}

