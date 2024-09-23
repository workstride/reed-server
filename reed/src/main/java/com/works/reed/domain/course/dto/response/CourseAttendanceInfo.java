package com.works.reed.domain.course.dto.response;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseAttendanceInfo {
    private String studentName;
    private Boolean isAttendance;
}
