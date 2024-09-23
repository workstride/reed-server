package com.works.reed.domain.academy.dao.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.academy.dto.AcadStudentInfo;
import com.works.reed.domain.academy.dto.AcadTeacherInfo;
import com.works.reed.domain.academy.dto.AcademyInfo;
import com.works.reed.domain.academy.dto.request.AcadStudentPageRequest;
import com.works.reed.domain.academy.dto.request.AcadTeacherPageRequest;
import com.works.reed.domain.academy.dto.request.AcademyPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.works.reed.domain.academy.domain.QAcadStudentEntity.acadStudentEntity;
import static com.works.reed.domain.academy.domain.QAcadTeacherEntity.acadTeacherEntity;
import static com.works.reed.domain.academy.domain.QAcademyEntity.academyEntity;
import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;
import static com.works.reed.domain.student.domain.QStudentEntity.studentEntity;
import static com.works.reed.domain.teacher.domain.QTeacherEntity.teacherEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class AcademyQueryRepositoryImpl implements AcademyQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Page<AcademyInfo> findAcademyByMemberId(Long memberId, AcademyPageRequest request) {
        List<AcademyInfo> result = queryFactory
                .select(academyInfoProjection())
                .from(academyEntity)
                .innerJoin(memberEntity).on(memberEntity.id.eq(academyEntity.memberId))
                .where(academyEntity.memberId.eq(memberId))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(academyEntity.id.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(academyEntity.id.count())
                .from(academyEntity)
                .innerJoin(memberEntity).on(memberEntity.id.eq(academyEntity.memberId))
                .where(academyEntity.memberId.eq(memberId));
        return PageableExecutionUtils.getPage(result, org.springframework.data.domain.PageRequest.of(request.getPage() - 1, request.getSize()), countQuery::fetchOne);
    }

    @Override
    public Page<AcadTeacherInfo> findTeachersByAcademyId(AcadTeacherPageRequest request) {
        List<AcadTeacherInfo> result = queryFactory
                .select(acadTeacherInfoProjection())
                .from(acadTeacherEntity)
                .innerJoin(teacherEntity).on(teacherEntity.id.eq(acadTeacherEntity.acadMemberId.memberId))
                .innerJoin(memberEntity).on(memberEntity.id.eq(teacherEntity.id))
                .where(acadTeacherEntity.acadMemberId.academyId.eq(request.getAcademyId()), search(request.getType(), request.getKeyword()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(acadTeacherEntity.acadMemberId.memberId.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(acadTeacherEntity.acadMemberId.count())
                .from(acadTeacherEntity)
                .innerJoin(teacherEntity).on(teacherEntity.id.eq(acadTeacherEntity.acadMemberId.memberId))
                .innerJoin(memberEntity).on(memberEntity.id.eq(teacherEntity.id))
                .where(acadTeacherEntity.acadMemberId.academyId.eq(request.getAcademyId()), search(request.getType(), request.getKeyword()));
        return PageableExecutionUtils.getPage(result, org.springframework.data.domain.PageRequest.of(request.getPage() - 1, request.getSize()), countQuery::fetchOne);
    }

    @Override
    public Optional<AcademyInfo> findAcademyByMemberId(Long memberId, Long academyId) {
        return Optional.ofNullable(queryFactory
                .select(academyInfoProjection())
                .from(academyEntity)
                .innerJoin(memberEntity).on(memberEntity.id.eq(academyEntity.memberId))
                .where(academyEntity.id.eq(academyId),
                        academyEntity.memberId.eq(memberId))
                .fetchOne()
        );
    }

    @Override
    public Page<AcadStudentInfo> findStudentsByAcademyId(AcadStudentPageRequest request) {
        List<AcadStudentInfo> result = queryFactory
                .select(acadStudentInfoProjection())
                .from(acadStudentEntity)
                .innerJoin(studentEntity).on(studentEntity.id.eq(acadStudentEntity.acadMemberId.memberId))
                .innerJoin(memberEntity).on(memberEntity.id.eq(studentEntity.id))
                .where(acadStudentEntity.acadMemberId.academyId.eq(request.getAcademyId()), search(request.getType(), request.getKeyword()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(acadStudentEntity.acadMemberId.memberId.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(acadStudentEntity.acadMemberId.count())
                .from(acadStudentEntity)
                .innerJoin(studentEntity).on(studentEntity.id.eq(acadStudentEntity.acadMemberId.memberId))
                .innerJoin(memberEntity).on(memberEntity.id.eq(studentEntity.id))
                .where(acadStudentEntity.acadMemberId.academyId.eq(request.getAcademyId()), search(request.getType(), request.getKeyword()));
        return PageableExecutionUtils.getPage(result, org.springframework.data.domain.PageRequest.of(request.getPage() - 1, request.getSize()), countQuery::fetchOne);
    }


    private ConstructorExpression<AcademyInfo> academyInfoProjection() {
        return Projections.constructor(
                AcademyInfo.class,
                academyEntity.id,
                academyEntity.memberId,
                academyEntity.name.as("acName"),
                academyEntity.tel.as("acTel"),
                academyEntity.address.address,
                academyEntity.address.zipcode,
                academyEntity.address.lat,
                academyEntity.address.lng,
                memberEntity.name.as("headTeacherName")
        );
    }

    private ConstructorExpression<AcadTeacherInfo> acadTeacherInfoProjection() {
        return Projections.constructor(
                AcadTeacherInfo.class,
                acadTeacherEntity.acadMemberId.memberId,
                acadTeacherEntity.acadMemberId.academyId,
                memberEntity.email,
                memberEntity.gender,
                memberEntity.birth,
                memberEntity.name,
                memberEntity.tel,
                teacherEntity.education
        );
    }

    private ConstructorExpression<AcadStudentInfo> acadStudentInfoProjection() {
        return Projections.constructor(
                AcadStudentInfo.class,
                acadStudentEntity.acadMemberId.memberId,
                acadStudentEntity.acadMemberId.academyId,
                memberEntity.email,
                memberEntity.gender,
                memberEntity.birth,
                memberEntity.name,
                memberEntity.tel,
                studentEntity.schulName,
                acadStudentEntity.regDate,
                acadStudentEntity.modDate
        );
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
                case "e":
                    conditionBuilder.or(memberEntity.email.contains(keyword));
                    break;
                case "t":
                    conditionBuilder.or(memberEntity.tel.contains(keyword));
                    break;
            }
        }
        return conditionBuilder;
    }
}
