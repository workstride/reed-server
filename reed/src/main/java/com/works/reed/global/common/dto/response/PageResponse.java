package com.works.reed.global.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageResponse <T> {
    private T list;
    private int totalPages;
}
