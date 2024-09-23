package com.works.reed.domain.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "인증 정보")
public class AuthRequest {
    @Schema(description = "회원 이메일")
    @NotBlank
    private String email;
    @Schema(description = "회원 비밀번호")
    @NotBlank
    private String pw;

    @Schema(description = "FCM Token")
    private String token;
}
