package com.works.reed.domain.course.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CourseInfo {
    private Long courseId;
    private Long memberId;
    private Long academyId;
    private String name;
    private String room;
    private Integer maxCnt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String teacherEmail;
    private String teacherName;
    private String teacherTel;
    private List<CourseScheduleInfo> schedules;
}
