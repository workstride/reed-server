package com.works.reed.domain.student.dao.querydsl;

import com.works.reed.domain.student.dto.StudentInfo;
import com.works.reed.domain.student.dto.request.StudentPageRequest;
import org.springframework.data.domain.Page;

public interface StudentQueryRepository {
    Page<StudentInfo> findStudents(StudentPageRequest request);
}
