package com.works.reed.domain.teacher.domain;


import com.works.reed.domain.teacher.enums.EducationType;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tbl_teacher")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TeacherEntity extends BaseEntity {

    @Id
    @Column(name = "mem_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private EducationType education;

}
