package com.works.reed.domain.student.application;

import com.works.reed.domain.student.dto.Student;

public interface StudentService {
    void register(Student student);
    void modify(Student student);
}
