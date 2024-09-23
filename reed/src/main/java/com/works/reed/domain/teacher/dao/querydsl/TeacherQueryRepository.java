package com.works.reed.domain.teacher.dao.querydsl;

import com.works.reed.domain.teacher.dto.TeacherInfo;
import com.works.reed.domain.teacher.dto.request.TeacherPageRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TeacherQueryRepository {
    Optional<TeacherInfo> findTeacherById(Long tcno);
    Page<TeacherInfo> findTeachers(TeacherPageRequest request);
}
