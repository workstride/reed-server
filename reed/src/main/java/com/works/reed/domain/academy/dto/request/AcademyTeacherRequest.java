package com.works.reed.domain.academy.dto.request;

import com.works.reed.domain.academy.dto.AcadTeacher;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademyTeacherRequest {

    @Schema(description = "학원 번호")
    @NotNull
    private Long academyId;

    @Schema(description = "선생님 회원번호")
    @NotNull
    private Long memberId;

    public AcadTeacher toAcadTeacher() {
        return AcadTeacher.builder()
                .academyId(academyId)
                .memberId(memberId)
                .build();
    }

}
