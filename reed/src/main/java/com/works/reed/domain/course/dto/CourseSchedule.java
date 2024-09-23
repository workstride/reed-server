package com.works.reed.domain.course.dto;

import com.works.reed.domain.course.enums.DayOfWeek;
import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CourseSchedule {
    private Long id;
    private Long courseId;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
