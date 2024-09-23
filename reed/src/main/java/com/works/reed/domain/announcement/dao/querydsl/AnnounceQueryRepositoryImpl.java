package com.works.reed.domain.announcement.dao.querydsl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnouncePageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.works.reed.domain.announcement.domain.QAnnounceEntity.announceEntity;

@Repository
@RequiredArgsConstructor
public class AnnounceQueryRepositoryImpl implements AnnounceQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<AnnounceInfo> findAnnounces(AnnouncePageRequest request) {
        List<AnnounceInfo> result = queryFactory
                .select(announceInfoProjection())
                .from(announceEntity)
                .where(announceEntity.acadMemberId.academyId.eq(request.getAcademyId()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(announceEntity.id.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(announceEntity.id.count())
                .from(announceEntity)
                .where(announceEntity.acadMemberId.academyId.eq(request.getAcademyId()));
        return PageableExecutionUtils.getPage(result, org.springframework.data.domain.PageRequest.of(request.getPage() - 1, request.getSize()), countQuery::fetchOne);
    }

    private ConstructorExpression<AnnounceInfo> announceInfoProjection() {
        return Projections.constructor(
                AnnounceInfo.class,
                announceEntity.id,
                announceEntity.annTitle,
                announceEntity.annContent,
                Expressions.dateTemplate(String.class, "DATE_FORMAT({0}, '%Y.%m.%d')", announceEntity.regDate)
        );
    }

}
