package com.works.reed.domain.course.dto.request;

import com.works.reed.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
public class CoursePageRequest extends PageRequest {

    @Schema(description = "학원번호")
    @NotNull
    private Long academyId;

}
