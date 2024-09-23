package com.works.reed.domain.student.dao.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.works.reed.domain.student.dto.StudentInfo;
import com.works.reed.domain.student.dto.request.StudentPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.works.reed.domain.member.domain.QMemberEntity.memberEntity;
import static com.works.reed.domain.student.domain.QStudentEntity.studentEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class StudentQueryRepositoryImpl implements StudentQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<StudentInfo> findStudents(StudentPageRequest request) {

        List<StudentInfo> result = queryFactory
                .select(studentInfoProjection())
                .from(studentEntity)
                .innerJoin(memberEntity).on(memberEntity.id.eq(studentEntity.id))
                .where(search(request.getType(), request.getKeyword()))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(studentEntity.id.desc())
                .fetch();
        JPAQuery<Long> countQuery = queryFactory
                .select(studentEntity.id.count())
                .from(studentEntity).where(search(request.getType(), request.getKeyword()));
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
                case "e":
                    conditionBuilder.or(memberEntity.email.contains(keyword));
                    break;
                case "s":
                    conditionBuilder.or(studentEntity.schulName.contains(keyword));
                    break;
            }
        }
        return conditionBuilder;
    }

    private ConstructorExpression<StudentInfo> studentInfoProjection() {
        return Projections.constructor(
                StudentInfo.class,
                studentEntity.id,
                studentEntity.schulName,
                studentEntity.atptOfcdcScCode,
                studentEntity.sdSchulCode,
                memberEntity.email,
                memberEntity.name,
                memberEntity.gender,
                memberEntity.birth,
                memberEntity.tel,
                studentEntity.regDate.as("scRegDate"),
                studentEntity.modDate.as("scModDate")
        );
    }


}
