package com.works.reed.domain.course.dto;

import com.works.reed.domain.course.enums.DayOfWeek;
import lombok.*;

import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseScheduleInfo {
    private Long id;
    private Long courseId;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
