package com.works.reed.domain.student.application.querydsl;

import com.works.reed.domain.student.dao.querydsl.StudentQueryRepository;
import com.works.reed.domain.student.dto.StudentInfo;
import com.works.reed.domain.student.dto.request.StudentPageRequest;
import com.works.reed.global.common.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class StudentQueryServiceImpl implements StudentQueryService {
    private final StudentQueryRepository studentQueryRepository;
    @Override
    public PageResponse<List<StudentInfo>> findStudents(StudentPageRequest request) {
        Page<StudentInfo> result = studentQueryRepository.findStudents(request);
        return new PageResponse(result.get(), result.getTotalPages());
    }
}
