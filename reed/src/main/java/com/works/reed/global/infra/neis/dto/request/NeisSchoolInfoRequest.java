package com.works.reed.global.infra.neis.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class NeisSchoolInfoRequest extends NeisDefaultRequest {
    @Schema(description = "학교 이름")
    @NotBlank
    private String schoolName;
}
