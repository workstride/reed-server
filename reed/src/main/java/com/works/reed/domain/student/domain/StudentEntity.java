package com.works.reed.domain.student.domain;

import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tbl_student")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentEntity extends BaseEntity {

    @Id
    @Column(name = "mem_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String schulName;

    @Column(length = 10, nullable = false)
    private String atptOfcdcScCode;

    @Column(length = 20, nullable = false)
    private String sdSchulCode;

}
