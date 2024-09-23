package com.works.reed.domain.course.domain;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_course")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CourseEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AcadMemberId acadMemberId;

    @Column(name = "cs_name", nullable = false, length = 50)
    private String name;

    @Column(name = "cs_room", nullable = false, length = 50)
    private String room;

    @Column(name = "cs_max_cnt", nullable = false)
    private Integer maxCnt;

    @Column(name = "cs_start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "cs_end_date")
    private LocalDateTime endDate;

}
