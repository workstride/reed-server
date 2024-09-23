package com.works.reed.domain.teacher.application.querdsl;

import com.works.reed.domain.teacher.dao.querydsl.TeacherQueryRepository;
import com.works.reed.domain.teacher.dto.TeacherInfo;
import com.works.reed.domain.teacher.dto.request.TeacherPageRequest;
import com.works.reed.domain.teacher.exception.NotFoundTeacherException;
import com.works.reed.global.common.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class TeacherQueryServiceImpl implements TeacherQueryService {

    private final TeacherQueryRepository teacherQueryRepository;

    @Override
    public ResponseEntity findTeacherById(Long id) {
        TeacherInfo teacherInfo = teacherQueryRepository.findTeacherById(id).orElseThrow(() -> NotFoundTeacherException.EXCEPTION);
        return ResponseEntity.ok(teacherInfo);
    }

    @Override
    public PageResponse<List<TeacherInfo>> findTeachers(TeacherPageRequest request) {
        Page<TeacherInfo> result = teacherQueryRepository.findTeachers(request);
        return new PageResponse<List<TeacherInfo>>(result.toList(), result.getTotalPages());
    }

}
