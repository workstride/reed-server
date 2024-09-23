package com.works.reed.domain.course.dto.response;

import com.works.reed.domain.course.enums.DayOfWeek;
import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseTodaySchedule {
    private Long courseId;
    private String name;
    private String room;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
