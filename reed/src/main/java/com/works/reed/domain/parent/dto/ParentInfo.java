package com.works.reed.domain.parent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParentInfo {
    private Long memberId;
    private Long childId;
    private String email;
    private String name;
}
