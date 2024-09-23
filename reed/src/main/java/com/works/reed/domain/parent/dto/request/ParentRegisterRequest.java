package com.works.reed.domain.parent.dto.request;

import com.works.reed.domain.parent.dto.Parent;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ParentRegisterRequest {

    @Schema(description = "부모 회원번호")
    @NotNull
    private Long memberId;

    @Schema(description = "자녀 회원번호")
    @NotNull
    private Long childId;

    public Parent toParent() {
        return Parent.builder()
                .memberId(memberId)
                .childId(childId)
                .build();
    }
}
