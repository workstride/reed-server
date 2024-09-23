package com.works.reed.domain.academy.domain;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tbl_academy_students")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AcadStudentEntity extends BaseEntity {

    @EmbeddedId
    private AcadMemberId acadMemberId;

}
