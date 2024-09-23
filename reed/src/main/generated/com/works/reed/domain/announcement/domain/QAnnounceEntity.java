package com.works.reed.domain.announcement.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnnounceEntity is a Querydsl query type for AnnounceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnounceEntity extends EntityPathBase<AnnounceEntity> {

    private static final long serialVersionUID = -914318954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnnounceEntity announceEntity = new QAnnounceEntity("announceEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final com.works.reed.domain.academy.domain.QAcademyEntity academy;

    public final StringPath annContent = createString("annContent");

    public final StringPath annTitle = createString("annTitle");

    public final StringPath annWriter = createString("annWriter");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QAnnounceEntity(String variable) {
        this(AnnounceEntity.class, forVariable(variable), INITS);
    }

    public QAnnounceEntity(Path<? extends AnnounceEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnnounceEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnnounceEntity(PathMetadata metadata, PathInits inits) {
        this(AnnounceEntity.class, metadata, inits);
    }

    public QAnnounceEntity(Class<? extends AnnounceEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.academy = inits.isInitialized("academy") ? new com.works.reed.domain.academy.domain.QAcademyEntity(forProperty("academy"), inits.get("academy")) : null;
    }

}

