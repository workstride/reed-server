package com.works.reed.domain.student.application;

import com.works.reed.domain.student.dao.StudentRepository;
import com.works.reed.domain.student.dto.Student;
import com.works.reed.domain.student.exception.ExistStudentException;
import com.works.reed.domain.student.exception.NotFoundStudentException;
import com.works.reed.domain.student.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public void register(Student student){
        if(studentRepository.findById(student.getId()).isPresent()){
            throw ExistStudentException.EXCEPTION;
        }
        studentRepository.save(studentMapper.createStudent(student));
    }

    @Override
    public void modify(Student student) {
        studentRepository.findById(student.getId()).orElseThrow(() -> NotFoundStudentException.EXCEPTION);
        studentRepository.save(studentMapper.createStudent(student));
    }


}
