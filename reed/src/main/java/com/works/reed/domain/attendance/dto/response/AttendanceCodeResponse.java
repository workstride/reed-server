package com.works.reed.domain.attendance.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AttendanceCodeResponse {
    private String code;
    private LocalDateTime date;
}
