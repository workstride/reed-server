package com.works.reed.domain.academy.dto;

import com.works.reed.domain.member.enums.GenderType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(description = "학원 학생 정보")
public class AcadStudentInfo {
    @Schema(description = "학생 회원번호")
    private Long memberId;
    @Schema(description = "학생 학원번호")
    private Long academyId;
    @Schema(description = "학생 이메일")
    private String email;
    @Schema(description = "학생 성별")
    private GenderType gender;
    @Schema(description = "학생 생년월일")
    private LocalDate birth;
    @Schema(description = "학생 이름")
    private String name;
    @Schema(description = "학생 전화번호")
    private String tel;
    @Schema(description = "학교 이름")
    private String schulName;
    @Schema(description = "학원 학생 등록일")
    private LocalDateTime regDate;
    @Schema(description = "학원 학생 수정일")
    private LocalDateTime modDate;
}
