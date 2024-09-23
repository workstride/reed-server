package com.works.reed.domain.parent.dao.querydsl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.parent.dto.ParentInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;
import static com.works.reed.domain.parent.domain.QParentEntity.parentEntity;


@Repository
@RequiredArgsConstructor
public class ParentQueryRepositoryImpl implements ParentQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ParentInfo> findParentsByChildId(Long memberId) {
        return queryFactory
                .select(parentInfoProjection())
                .from(parentEntity)
                .innerJoin(memberEntity).on(parentEntity.id.memberId.eq(memberEntity.id))
                .where(
                        parentEntity.id.childId.eq(memberId)
                )
                .fetch();
    }

    private ConstructorExpression<ParentInfo> parentInfoProjection() {
        return Projections.constructor(
                ParentInfo.class,
                parentEntity.id.memberId,
                parentEntity.id.childId,
                memberEntity.email,
                memberEntity.name
        );
    }
}
