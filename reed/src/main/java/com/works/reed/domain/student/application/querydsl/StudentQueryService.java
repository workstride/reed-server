package com.works.reed.domain.student.application.querydsl;

import com.works.reed.domain.student.dto.StudentInfo;
import com.works.reed.domain.student.dto.request.StudentPageRequest;
import com.works.reed.global.common.dto.response.PageResponse;

import java.util.List;

public interface StudentQueryService {
    PageResponse<List<StudentInfo>> findStudents(StudentPageRequest request);

}
