package com.works.reed.domain.academy.dto.request;

import com.works.reed.domain.academy.dto.AcadStudent;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademyStudentRequest {

    @Schema(description = "학원 번호")
    @NotNull
    private Long academyId;

    @Schema(description = "학생 회원번호")
    @NotNull
    private Long memberId;

    public AcadStudent toAcadStudent() {
        return AcadStudent.builder()
                .academyId(academyId)
                .memberId(memberId)
                .build();
    }

}
