package com.works.reed.domain.academy.mapper;

import com.works.reed.domain.academy.domain.AcadStudentEntity;
import com.works.reed.domain.academy.domain.AcadTeacherEntity;
import com.works.reed.domain.academy.domain.AcademyEntity;
import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.domain.academy.dto.AcadStudent;
import com.works.reed.domain.academy.dto.AcadTeacher;
import com.works.reed.domain.academy.dto.Academy;
import com.works.reed.global.common.embed.Address;
import org.springframework.stereotype.Component;

@Component
public class AcademyMapper {

    public AcademyEntity createAcademy(Academy academy) {
        return AcademyEntity.builder()
                .id(academy.getId())
                .memberId(academy.getMemberId())
                .name(academy.getName())
                .tel(academy.getTel())
                .address(
                        Address.builder()
                                .address(academy.getAddress())
                                .zipcode(academy.getZipcode())
                                .lat(academy.getLat())
                                .lng(academy.getLng()).build()
                ).build();

    }

    public AcadTeacherEntity createAcadTeacher(AcadTeacher teacher) {
        return AcadTeacherEntity.builder()
                .acadMemberId(
                        createAcadMemberId(teacher.getAcademyId(), teacher.getMemberId())
                )
                .build();
    }

    public AcadStudentEntity createAcadStudent(AcadStudent student) {
        return AcadStudentEntity.builder()
                .acadMemberId(
                        createAcadMemberId(student.getAcademyId(), student.getMemberId())
                )
                .build();
    }
    public AcadMemberId createAcadMemberId(Long academyId, Long memberId){
        return AcadMemberId.builder().memberId(memberId).academyId(academyId).build();
    }
}
