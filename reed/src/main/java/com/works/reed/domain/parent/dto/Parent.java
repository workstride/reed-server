package com.works.reed.domain.parent.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent {
    private Long memberId;
    private Long childId;
}
