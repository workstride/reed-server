package com.works.reed.domain.attendance.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    private Long id;
    private Long courseStudentId;
    private LocalDate date;
    private LocalTime time;
}
