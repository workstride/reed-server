package com.works.reed.domain.academy.dao.querydsl;

import com.works.reed.domain.academy.dto.AcadStudentInfo;
import com.works.reed.domain.academy.dto.AcadTeacherInfo;
import com.works.reed.domain.academy.dto.AcademyInfo;
import com.works.reed.domain.academy.dto.request.AcadStudentPageRequest;
import com.works.reed.domain.academy.dto.request.AcadTeacherPageRequest;
import com.works.reed.domain.academy.dto.request.AcademyPageRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AcademyQueryRepository {
    Page<AcademyInfo> findAcademyByMemberId(Long memberId, AcademyPageRequest request);
    Optional<AcademyInfo> findAcademyByMemberId(Long memberId, Long academyId);
    Page<AcadTeacherInfo> findTeachersByAcademyId(AcadTeacherPageRequest request);
    Page<AcadStudentInfo> findStudentsByAcademyId(AcadStudentPageRequest request);
}
