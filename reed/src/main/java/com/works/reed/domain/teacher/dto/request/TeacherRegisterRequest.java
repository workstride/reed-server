package com.works.reed.domain.teacher.dto.request;

import com.works.reed.domain.teacher.dto.Teacher;
import com.works.reed.domain.teacher.enums.EducationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRegisterRequest {

    @Schema(description = "선생님 회원번호")
    @NotNull
    private Long id;

    @Schema(description = "최종 학력")
    @NotNull
    private EducationType education;

    public Teacher toTeacher() {
        return Teacher.builder()
                .id(id)
                .education(education)
                .build();
    }
}
