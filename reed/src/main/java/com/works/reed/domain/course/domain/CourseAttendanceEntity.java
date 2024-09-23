package com.works.reed.domain.course.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_course_attendance")
public class CourseAttendanceEntity {
    @Id
    @Column(name = "student_name", nullable = false)
    private String studentName;
    @Column(name = "is_attendance")
    private boolean isAttendance;
}
