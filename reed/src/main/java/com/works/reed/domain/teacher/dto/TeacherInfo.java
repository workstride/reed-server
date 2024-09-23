package com.works.reed.domain.teacher.dto;

import com.works.reed.domain.member.enums.GenderType;
import com.works.reed.domain.teacher.enums.EducationType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInfo {
    @Schema(description = "선생님 회원번호")
    private Long id;
    @Schema(description = "선생님 이름")
    private String name;
    @Schema(description = "선생님 이메일")
    private String email;
    @Schema(description = "선생님 성별")
    private GenderType gender;
    @Schema(description = "선생님 생년월일")
    private LocalDate birth;
    @Schema(description = "선생님 전화번호")
    private String tel;
    @Schema(description = "학력")
    private EducationType education;
}
