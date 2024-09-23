package com.works.reed.domain.course.dto.request;

import com.works.reed.domain.academy.dto.AcadStudent;
import com.works.reed.domain.course.dto.CourseStudent;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseStudRegisterRequest {

    @Schema(description = "학원번호")
    @NotNull
    private Long academyId;

    @Schema(description = "학원 학생 회원번호")
    @NotNull
    private Long memberId;

    @Schema(description = "수업번호")
    @NotNull
    private Long courseId;

    public CourseStudent toCourseStudent() {
        return CourseStudent.builder()
                .academyStudent(
                        AcadStudent.builder()
                                .academyId(academyId)
                                .memberId(memberId)
                                .build()
                )
                .courseId(courseId)
                .build();
    }

}
