package com.works.reed.domain.teacher.dto.request;

import com.works.reed.domain.teacher.dto.Teacher;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRemoveRequest {

    @Schema(description = "선생님 회원번호")
    @NotNull
    private Long id;

    public Teacher toTeacher() {
        return Teacher.builder()
                .id(id)
                .build();
    }

}
