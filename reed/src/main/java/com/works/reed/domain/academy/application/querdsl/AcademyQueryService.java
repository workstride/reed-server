package com.works.reed.domain.academy.application.querdsl;

import com.works.reed.domain.academy.dto.AcademyInfo;
import com.works.reed.domain.academy.dto.request.AcadStudentPageRequest;
import com.works.reed.domain.academy.dto.request.AcadTeacherPageRequest;
import com.works.reed.domain.academy.dto.request.AcademyPageRequest;
import com.works.reed.global.common.dto.response.PageResponse;

public interface AcademyQueryService {
    PageResponse findAcademy(AcademyPageRequest request);
    PageResponse findAcademyTeachers(AcadTeacherPageRequest request);
    AcademyInfo findByAcademyId(Long academyId);
    PageResponse findAcademyStudents(AcadStudentPageRequest request);

}
