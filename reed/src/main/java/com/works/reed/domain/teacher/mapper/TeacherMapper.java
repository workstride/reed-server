package com.works.reed.domain.teacher.mapper;

import com.works.reed.domain.teacher.domain.TeacherEntity;
import com.works.reed.domain.teacher.dto.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherEntity createTeacher(Teacher teacher) {
        return TeacherEntity.builder()
                .id(teacher.getId())
                .education(teacher.getEducation())
                .build();
    }

}
