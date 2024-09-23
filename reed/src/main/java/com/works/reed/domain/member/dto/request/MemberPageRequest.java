package com.works.reed.domain.member.dto.request;

import com.works.reed.domain.member.enums.MemberRole;
import com.works.reed.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPageRequest extends PageRequest {
    @Schema(description = "회원 타입")
    private MemberRole role;
}
