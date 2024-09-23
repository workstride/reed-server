package com.works.reed.domain.academy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(description = "학원 정보")
public class AcademyInfo {
    @Schema(description = "학원 번호")
    private Long id;
    @Schema(description = "원장 회원번호")
    private Long memberId;
    @Schema(description = "학원 이름")
    private String acName;
    @Schema(description = "학원 전화번호")
    private String acTel;
    @Schema(description = "학원 주소")
    private String address;
    @Schema(description = "학원 우편번호")
    private String zipcode;
    private double lat, lng;
    @Schema(description = "원장 이름")
    private String headTeacherName;
}
