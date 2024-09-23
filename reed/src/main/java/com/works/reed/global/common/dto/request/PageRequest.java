package com.works.reed.global.common.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@SuperBuilder
public class PageRequest {
    @Schema(description = "페이지 번호")
    private int page;
    @Schema(description = "페이지 사이즈")
    private int size;
    private String type;
    private String keyword;

    public PageRequest() {
        page = 1;
        size = 10;
    }

    @Schema(hidden = true)
    public Pageable getPageable(){
        return org.springframework.data.domain.PageRequest
                .of(page-1, size);
    }

}
