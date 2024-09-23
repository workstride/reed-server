package com.works.reed.domain.teacher.application.querdsl;

import com.works.reed.domain.teacher.dto.TeacherInfo;
import com.works.reed.domain.teacher.dto.request.TeacherPageRequest;
import com.works.reed.global.common.dto.response.PageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherQueryService {
    ResponseEntity findTeacherById(Long id);
    PageResponse<List<TeacherInfo>> findTeachers(TeacherPageRequest request);
}
