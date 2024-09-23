package com.works.reed.domain.academy.application;

import com.works.reed.domain.academy.dto.AcadStudent;
import com.works.reed.domain.academy.dto.AcadTeacher;
import com.works.reed.domain.academy.dto.Academy;

public interface AcademyService {
    void register(Academy academy);
    void remove(Long academyId);
    void registerTeacher(AcadTeacher teacher);
    void removeTeacher(AcadTeacher teacher);
    void registerStudent(AcadStudent student);
    void removeStudent(AcadStudent student);
}
