package com.works.reed.domain.attendance.dto.request;

import com.works.reed.domain.attendance.dto.AttendanceCode;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceCodeRequest {

    @NotNull
    private Long courseId;
    @NotNull
    private Long academyId;
    @NotNull
    private Long memberId;

    public AttendanceCode toAttendanceCode() {
        return AttendanceCode.builder()
                .courseId(courseId)
                .academyId(academyId)
                .memberId(memberId)
                .active(true)
                .build();
    }
}
