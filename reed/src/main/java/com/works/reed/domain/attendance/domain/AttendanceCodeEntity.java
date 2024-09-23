package com.works.reed.domain.attendance.domain;


import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.domain.attendance.domain.enums.AttendanceCodeType;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tbl_attendance_code")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AttendanceCodeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AcadMemberId acadMemberId;

    @Column(name = "cs_id", nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private AttendanceCodeType type;

    @Column(nullable = false, unique = true)
    private String code;

    private boolean active;

}
