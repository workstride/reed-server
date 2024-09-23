package com.works.reed.domain.member.dto;

import com.works.reed.domain.member.enums.GenderType;
import com.works.reed.domain.member.enums.MemberRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "회원 정보")
public class MemberInfo {
    @Schema(description = "회원번호")
    private Long id;
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "성별")
    private GenderType gender;
    @Schema(description = "생년월일")
    private LocalDate birth;
    @Schema(description = "이름")
    private String name;
    @Schema(description = "전화번호")
    private String tel;
    @Schema(description = "역할")
    private MemberRole role;
    @Schema(hidden = true)
    private LocalDateTime modDate;
    @Schema(description = "가입일")
    private LocalDateTime regDate;
}
