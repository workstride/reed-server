package com.works.reed.domain.student.mapper;

import com.works.reed.domain.student.domain.StudentEntity;
import com.works.reed.domain.student.dto.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentEntity createStudent(Student student) {
        return StudentEntity.builder()
                .id(student.getId())
                .schulName(student.getSchulName())
                .atptOfcdcScCode(student.getAtptOfcdcScCode())
                .sdSchulCode(student.getSdSchulCode())
                .build();
    }
}
