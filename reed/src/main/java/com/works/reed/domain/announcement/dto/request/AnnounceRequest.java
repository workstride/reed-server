package com.works.reed.domain.announcement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnounceRequest {
    @NotNull
    private Long academyId;
    //    @NotNull
//    private Long memberId;
    @NotBlank
    private String annTitle;
    @NotBlank
    private String annContent;
}
