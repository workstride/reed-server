package com.works.reed.domain.course.domain;

import com.works.reed.domain.course.enums.DayOfWeek;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;


@Entity
@Table(name = "tbl_course_schedule")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CourseScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cs_id", nullable = false)
    private Long courseId;

    @Column(name = "cs_week", nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "cs_start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "cs_end_time", nullable = false)
    private LocalTime endTime;
}
