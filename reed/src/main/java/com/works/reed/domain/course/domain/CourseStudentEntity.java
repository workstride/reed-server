package com.works.reed.domain.course.domain;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tbl_course_registration")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CourseStudentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AcadMemberId acadMemberId;

    @Column(name = "cs_id", nullable = false)
    private Long courseId;

}
