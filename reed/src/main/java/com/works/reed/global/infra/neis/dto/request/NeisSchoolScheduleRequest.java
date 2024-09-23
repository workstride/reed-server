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
public class NeisSchoolScheduleRequest extends NeisDefaultRequest{
    @Schema(description = "시교육청코드")
    @NotBlank
    private String atptOfcdcScCode;
    @Schema(description = "학교 코드")
    @NotBlank
    private String sdSchulCode;
    @Schema(description = "")
    private String date;
    public String getDate(){
        return (date == null)?"":date;
    }
}
