package com.works.reed.domain.academy.application.querdsl;

import com.works.reed.domain.academy.dao.querydsl.AcademyQueryRepository;
import com.works.reed.domain.academy.dto.AcadStudentInfo;
import com.works.reed.domain.academy.dto.AcadTeacherInfo;
import com.works.reed.domain.academy.dto.AcademyInfo;
import com.works.reed.domain.academy.dto.request.AcadStudentPageRequest;
import com.works.reed.domain.academy.dto.request.AcadTeacherPageRequest;
import com.works.reed.domain.academy.dto.request.AcademyPageRequest;
import com.works.reed.domain.academy.exception.NotFoundAcademyException;
import com.works.reed.global.common.dao.MemberSecurity;
import com.works.reed.global.common.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AcademyQueryServiceImpl implements AcademyQueryService {

    private final MemberSecurity memberSecurity;
    private final AcademyQueryRepository academyQueryRepository;

    public PageResponse findAcademy(AcademyPageRequest request){
        Page<AcademyInfo> result = academyQueryRepository.findAcademyByMemberId(memberSecurity.getMember().getId(), request);
        return new PageResponse<List<AcademyInfo>>(result.toList(), result.getTotalPages());
    }

    @Override
    public PageResponse findAcademyTeachers(AcadTeacherPageRequest request) {
        Page<AcadTeacherInfo> result = academyQueryRepository.findTeachersByAcademyId(request);
        return new PageResponse(result.toList(), result.getTotalPages());
    }

    @Override
    public AcademyInfo findByAcademyId(Long academyId) {
        return academyQueryRepository.findAcademyByMemberId(memberSecurity.getMember().getId(), academyId).orElseThrow(() -> NotFoundAcademyException.EXCEPTION);
    }

    @Override
    public PageResponse findAcademyStudents(AcadStudentPageRequest request) {
        Page<AcadStudentInfo> result = academyQueryRepository.findStudentsByAcademyId(request);
        return new PageResponse(result.toList(), result.getTotalPages());
    }

}
