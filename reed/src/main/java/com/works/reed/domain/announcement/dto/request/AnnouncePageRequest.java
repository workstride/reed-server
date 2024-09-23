package com.works.reed.domain.announcement.dto.request;

import com.works.reed.global.common.dto.request.PageRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
public class AnnouncePageRequest extends PageRequest {
    @NotNull
    private Long academyId;


}
