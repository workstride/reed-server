package com.works.reed.domain.course.dto;

import com.works.reed.domain.academy.dto.AcadTeacher;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Course {
    private Long id;
    private AcadTeacher academyTeacher;
    private String name;
    private String room;
    private Integer maxCnt;
    private LocalDateTime startDate, endDate;
}
