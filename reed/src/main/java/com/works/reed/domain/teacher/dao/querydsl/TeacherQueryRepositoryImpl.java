package com.works.reed.domain.teacher.dao.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.teacher.dto.TeacherInfo;
import com.works.reed.domain.teacher.dto.request.TeacherPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;
import static com.works.reed.domain.teacher.domain.QTeacherEntity.teacherEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class TeacherQueryRepositoryImpl implements TeacherQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<TeacherInfo> findTeacherById(Long id) {
        return Optional.ofNullable(queryFactory
                .select(teacherInfoProjection())
                .from(teacherEntity)
                .innerJoin(memberEntity).on(memberEntity.id.eq(teacherEntity.id))
                .where(teacherEntity.id.eq(id))
                .fetchOne());
    }

    @Override
    public Page<TeacherInfo> findTeachers(TeacherPageRequest request) {
        List<TeacherInfo> result = queryFactory
                .select(teacherInfoProjection())
                .from(teacherEntity)
                .innerJoin(memberEntity).on(memberEntity.id.eq(teacherEntity.id))
                .where(search(request.getType(), request.getKeyword()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(teacherEntity.id.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(teacherEntity.id.count())
                .from(teacherEntity).where(search(request.getType(), request.getKeyword()));
        return PageableExecutionUtils.getPage(result, org.springframework.data.domain.PageRequest.of(request.getPage() - 1, request.getSize()), countQuery::fetchOne);
    }

    private BooleanBuilder search(String type, String keyword) {

        if (!hasText(type))
            return null;

        String[] typeArr = type.split("");
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        for (String t : typeArr) {
            switch (t) {
                case "n":
                    conditionBuilder.or(memberEntity.name.contains(keyword));
                    break;
                case "t":
                    conditionBuilder.or(memberEntity.tel.contains(keyword));
                    break;
                case "e":
                    conditionBuilder.or(memberEntity.email.contains(keyword));
                    break;
            }
        }
        return conditionBuilder;
    }

    private ConstructorExpression<TeacherInfo> teacherInfoProjection() {
        return Projections.constructor(
                TeacherInfo.class,
                teacherEntity.id,
                memberEntity.name,
                memberEntity.email,
                memberEntity.gender,
                memberEntity.birth,
                memberEntity.tel,
                teacherEntity.education
        );
    }
}
