package com.works.reed.domain.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.works.reed.domain.member.dto.Member;
import com.works.reed.domain.member.enums.GenderType;
import com.works.reed.domain.member.enums.MemberRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "회원 등록")
public class RegisterRequest {
    @NotBlank
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;

    @Schema(description = "비밀번호")
    @NotBlank
    @Size(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하로 입력해주세요.")
    private String pw;

    @Schema(description = "회원 성별")
    @NotNull
    private GenderType gender;

    @Schema(description = "회원 생년월일")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate birth;

    @Schema(description = "회원 이름")
    @NotBlank
    private String name;

    @Schema(description = "회원 전화번호")
    @NotBlank
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String tel;

    @Schema(description = "회원 타입")
    @NotNull
    private MemberRole role;

    public Member toMember(){
        return Member.builder()
                .email(email)
                .pw(pw)
                .birth(birth)
                .gender(gender)
                .name(name)
                .tel(tel)
                .role(role)
                .build();
    }
}
