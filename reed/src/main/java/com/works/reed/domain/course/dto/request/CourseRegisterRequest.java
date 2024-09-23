package com.works.reed.domain.course.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.works.reed.domain.academy.dto.AcadTeacher;
import com.works.reed.domain.course.dto.Course;
import com.works.reed.domain.course.dto.CourseSchedule;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CourseRegisterRequest {

    @Schema(description = "학원번호")
    @NotNull
    private Long academyId;

    @Schema(description = "학원 선생님 회원번호")
    @NotNull
    private Long memberId;

    @Schema(description = "수업(강의)명")
    @NotBlank
    private String name;

    @Schema(description = "수업 장소")
    @NotBlank
    private String room;

    @Schema(description = "최대 인원")
    @Min(1)
    private int maxCnt;

    @Schema(description = "수업시작일", example = "2023-01-01 12:00:00", type = "string")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Schema(description = "수업종료일", example = "2023-12-31 12:00:00", type = "string")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Schema(description = "수업 스케줄 정보")
    @NotNull
    private List<CourseScheduleRequest> schedules;

    public Course toCourseDTO() {
        return Course.builder()
                .academyTeacher(
                        AcadTeacher.builder()
                                .academyId(academyId)
                                .memberId(memberId)
                                .build()
                )
                .name(name)
                .room(room)
                .maxCnt(maxCnt)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    public List<CourseSchedule> toCourseSchedules() {
        return schedules.stream().map(CourseScheduleRequest::toClassSchedule).collect(Collectors.toList());
    }

}
