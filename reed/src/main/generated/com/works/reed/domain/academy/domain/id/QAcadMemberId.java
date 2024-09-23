package com.works.reed.domain.academy.domain.id;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAcadMemberId is a Querydsl query type for AcadMemberId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAcadMemberId extends BeanPath<AcadMemberId> {

    private static final long serialVersionUID = 869924012L;

    public static final QAcadMemberId acadMemberId = new QAcadMemberId("acadMemberId");

    public final NumberPath<Long> academyId = createNumber("academyId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QAcadMemberId(String variable) {
        super(AcadMemberId.class, forVariable(variable));
    }

    public QAcadMemberId(Path<? extends AcadMemberId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAcadMemberId(PathMetadata metadata) {
        super(AcadMemberId.class, metadata);
    }

}

