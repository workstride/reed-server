package com.works.reed.domain.academy.dto.request;

import com.works.reed.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class AcadTeacherPageRequest extends PageRequest {
    @Schema(description = "학원 번호")
    @NotNull
    private Long academyId;
}
