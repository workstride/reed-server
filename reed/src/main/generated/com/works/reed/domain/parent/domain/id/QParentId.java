package com.works.reed.domain.parent.domain.id;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QParentId is a Querydsl query type for ParentId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QParentId extends BeanPath<ParentId> {

    private static final long serialVersionUID = 1996055019L;

    public static final QParentId parentId = new QParentId("parentId");

    public final NumberPath<Long> childId = createNumber("childId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QParentId(String variable) {
        super(ParentId.class, forVariable(variable));
    }

    public QParentId(Path<? extends ParentId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParentId(PathMetadata metadata) {
        super(ParentId.class, metadata);
    }

}

