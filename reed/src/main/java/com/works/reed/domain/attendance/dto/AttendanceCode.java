package com.works.reed.domain.attendance.dto;

import com.works.reed.domain.attendance.domain.enums.AttendanceCodeType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceCode {
    private Long id;
    private Long courseId;
    private Long academyId;
    private Long memberId;
    private String code;
    private AttendanceCodeType type;
    private boolean active;
}
