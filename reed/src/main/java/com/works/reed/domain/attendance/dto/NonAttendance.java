package com.works.reed.domain.attendance.dto;

import com.works.reed.domain.course.enums.DayOfWeek;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NonAttendance {
    private Long courseId;
    private String courseName;
    private String email;
    private String name;
    private Long academyId;
    private Long memberId;
    private DayOfWeek dayOfWeek;
    private LocalTime courseStartTime;
    private LocalTime courseEndTime;
}
