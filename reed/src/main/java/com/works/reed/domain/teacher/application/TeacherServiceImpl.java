package com.works.reed.domain.teacher.application;

import com.works.reed.domain.teacher.dao.TeacherRepository;
import com.works.reed.domain.teacher.dto.Teacher;
import com.works.reed.domain.teacher.exception.ExistTeacherException;
import com.works.reed.domain.teacher.exception.NotFoundTeacherException;
import com.works.reed.domain.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public void register(Teacher teacher) {
        if (teacherRepository.findById(teacher.getId()).isPresent()) {
            throw ExistTeacherException.EXCEPTION;
        }
        teacherRepository.save(teacherMapper.createTeacher(teacher));
    }

    @Override
    public void modify(Teacher teacher) {
        teacherRepository.findById(teacher.getId()).orElseThrow(() -> NotFoundTeacherException.EXCEPTION);
        teacherRepository.save(teacherMapper.createTeacher(teacher));
    }

    @Override
    public void remove(Teacher teacher) {
        teacherRepository.findById(teacher.getId()).orElseThrow(() -> NotFoundTeacherException.EXCEPTION);
        teacherRepository.deleteById(teacher.getId());
    }

}
