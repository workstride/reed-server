package com.works.reed.global.infra.neis.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class NeisDefaultRequest {
    private int page;
    private int size;

    public NeisDefaultRequest() {
        this.page = 1;
        this.size = 20;
    }

}
