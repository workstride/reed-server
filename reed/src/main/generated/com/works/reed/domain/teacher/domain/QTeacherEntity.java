package com.works.reed.domain.teacher.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTeacherEntity is a Querydsl query type for TeacherEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeacherEntity extends EntityPathBase<TeacherEntity> {

    private static final long serialVersionUID = 424114478L;

    public static final QTeacherEntity teacherEntity = new QTeacherEntity("teacherEntity");

    public final com.works.reed.global.common.entity.QBaseEntity _super = new com.works.reed.global.common.entity.QBaseEntity(this);

    public final EnumPath<com.works.reed.domain.teacher.enums.EducationType> education = createEnum("education", com.works.reed.domain.teacher.enums.EducationType.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QTeacherEntity(String variable) {
        super(TeacherEntity.class, forVariable(variable));
    }

    public QTeacherEntity(Path<? extends TeacherEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeacherEntity(PathMetadata metadata) {
        super(TeacherEntity.class, metadata);
    }

}

