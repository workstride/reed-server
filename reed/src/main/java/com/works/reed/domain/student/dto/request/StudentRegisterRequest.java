package com.works.reed.domain.student.dto.request;


import com.works.reed.domain.student.dto.Student;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentRegisterRequest {

    @Schema(description = "학생 회원번호")
    @NotNull
    private Long id;

    @Schema(description = "학교 이름")
    @NotBlank
    private String schulName;

    @Schema(description = "시도교육청코드")
    @NotBlank
    private String atptOfcdcScCode;

    @Schema(description = "표준학교코드")
    @NotBlank
    private String sdSchulCode;

    public Student toStudent() {
        return Student.builder()
                .id(id)
                .schulName(schulName)
                .atptOfcdcScCode(atptOfcdcScCode)
                .sdSchulCode(sdSchulCode)
                .build();
    }

}
