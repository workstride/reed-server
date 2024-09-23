package com.works.reed.domain.academy.application;

import com.works.reed.domain.academy.dao.AcademyRepository;
import com.works.reed.domain.academy.dao.AcademyStudentRepository;
import com.works.reed.domain.academy.dao.AcademyTeacherRepository;
import com.works.reed.domain.academy.domain.AcadStudentEntity;
import com.works.reed.domain.academy.domain.AcadTeacherEntity;
import com.works.reed.domain.academy.dto.AcadStudent;
import com.works.reed.domain.academy.dto.AcadTeacher;
import com.works.reed.domain.academy.dto.Academy;
import com.works.reed.domain.academy.exception.*;
import com.works.reed.domain.academy.mapper.AcademyMapper;
import com.works.reed.global.common.dao.MemberSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final MemberSecurity memberSecurity;
    private final AcademyRepository repository;
    private final AcademyTeacherRepository academyTeacherRepository;
    private final AcademyStudentRepository academyStudentRepository;

    private final AcademyMapper academyMapper;

    @Override
    public void register(Academy academy) {
        repository.save(academyMapper.createAcademy(academy));
    }

    @Override
    public void remove(Long academyId) {
        repository.findByIdAndMemberId(academyId, memberSecurity.getMember().getId()).orElseThrow(() -> NotFoundAcademyException.EXCEPTION);
        repository.deleteById(academyId);
    }

    @Override
    public void registerTeacher(AcadTeacher teacher) {
        if (academyTeacherRepository.findById(academyMapper.createAcadMemberId(teacher.getAcademyId(), teacher.getMemberId())).isPresent()) {
            throw ExistAcadTeacherException.EXCEPTION;
        }
        academyTeacherRepository.save(academyMapper.createAcadTeacher(teacher));
    }

    @Override
    public void removeTeacher(AcadTeacher teacher) {
        AcadTeacherEntity acadTeacherEntity = academyTeacherRepository.findById(academyMapper.createAcadMemberId(teacher.getAcademyId(), teacher.getMemberId())).orElseThrow(() -> NotFoundAcadTeacherException.EXCEPTION);
        academyTeacherRepository.delete(acadTeacherEntity);
    }

    @Override
    public void registerStudent(AcadStudent student) {
        if (academyStudentRepository.findById(academyMapper.createAcadMemberId(student.getAcademyId(),student.getMemberId())).isPresent()) {
            throw ExistAcadStudentException.EXCEPTION;
        }
        academyStudentRepository.save(academyMapper.createAcadStudent(student));
    }

    @Override
    public void removeStudent(AcadStudent student) {
        AcadStudentEntity acadStudentEntity = academyStudentRepository.findById(academyMapper.createAcadMemberId(student.getAcademyId(), student.getMemberId())).orElseThrow(() -> NotFoundAcadStudentException.EXCEPTION);
        academyStudentRepository.delete(acadStudentEntity);
    }

}
