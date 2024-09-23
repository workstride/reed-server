package com.works.reed.domain.member.dao.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.member.dto.MemberInfo;
import com.works.reed.domain.member.dto.request.MemberPageRequest;
import com.works.reed.domain.member.enums.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<MemberInfo> findMembers(MemberPageRequest request) {
        List<MemberInfo> result = queryFactory
                .select(memberInfoProjection())
                .from(memberEntity)
                .where(eqMemberRole(request.getRole()), search(request.getType(), request.getKeyword()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(memberEntity.id.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(memberEntity.id.count())
                .from(memberEntity).where(eqMemberRole(request.getRole()), search(request.getType(), request.getKeyword()));
        return PageableExecutionUtils.getPage(result, org.springframework.data.domain.PageRequest.of(request.getPage() - 1, request.getSize()), countQuery::fetchOne);
    }

    @Override
    public Optional<MemberInfo> findMember(Long memberId) {
        return Optional.ofNullable(queryFactory.select(memberInfoProjection())
                .from(memberEntity)
                .where(memberEntity.id.eq(memberId))
                .fetchOne());
    }

    private BooleanExpression eqMemberRole(MemberRole role) {
        if (role == null) return null;
        return memberEntity.role.eq(role);
    }

    private BooleanBuilder search(String type, String keyword) {

        if (!hasText(type))
            return null;

        String[] typeArr = type.split("");
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        for (String t : typeArr) {
            switch (t) {
                case "e":
                    conditionBuilder.or(memberEntity.email.contains(keyword));
                    break;
                case "n":
                    conditionBuilder.or(memberEntity.name.contains(keyword));
                    break;
                case "t":
                    conditionBuilder.or(memberEntity.tel.contains(keyword));
                    break;
            }
        }
        return conditionBuilder;
    }

    private ConstructorExpression<MemberInfo> memberInfoProjection() {
        return Projections.constructor(
                MemberInfo.class,
                memberEntity.id,
                memberEntity.email,
                memberEntity.gender,
                memberEntity.birth,
                memberEntity.name,
                memberEntity.tel,
                memberEntity.role,
                memberEntity.modDate,
                memberEntity.regDate
        );
    }
}
