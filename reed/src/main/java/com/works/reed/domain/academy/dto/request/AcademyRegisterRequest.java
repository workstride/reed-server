package com.works.reed.domain.academy.dto.request;

import com.works.reed.domain.academy.dto.Academy;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "학원 등록 정보")
public class AcademyRegisterRequest {

    @Schema(description = "원장 회원번호")
    @NotNull
    private Long memberId;

    @Schema(description = "학원 이름")
    @NotBlank
    private String name;

    @Schema(description = "학원 전화번호")
    @NotBlank
    private String tel;

    @Schema(description = "학원 주소")
    @NotBlank
    private String address;

    @Schema(description = "학원 우편번호")
    @NotBlank
    private String zipcode;

    private double lat, lng; // 위도,경도

    public Academy toAcademy() {
        return Academy.builder()
                .memberId(memberId)
                .name(name)
                .tel(tel)
                .address(address)
                .zipcode(zipcode)
                .lat(lat)
                .lng(lng)
                .build();
    }

}
