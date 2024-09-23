package com.works.reed.domain.course.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.works.reed.domain.course.dto.CourseSchedule;
import com.works.reed.domain.course.enums.DayOfWeek;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseScheduleRequest {

    @Schema(description = "수업요일")
    @NotNull
    private DayOfWeek dayOfWeek;

    @Schema(description = "수업시작시간", example = "09:00:00", type = "string")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime startTime;

    @Schema(description = "수업종료시갼", example = "10:00:00", type = "string")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime endTime;


    public static CourseSchedule toClassSchedule(CourseScheduleRequest request) {
        return CourseSchedule.builder()
                .dayOfWeek(request.dayOfWeek)
                .startTime(request.startTime)
                .endTime(request.endTime)
                .build();
    }

}
