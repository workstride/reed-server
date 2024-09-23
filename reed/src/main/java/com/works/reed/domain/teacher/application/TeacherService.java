package com.works.reed.domain.teacher.application;

import com.works.reed.domain.teacher.dto.Teacher;

public interface TeacherService {
  void register(Teacher teacher);
  void modify(Teacher teacher);
  void remove(Teacher teacher);
}
