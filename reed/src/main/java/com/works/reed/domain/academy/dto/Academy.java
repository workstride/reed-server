package com.works.reed.domain.academy.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Academy {
    private Long id;
    private Long memberId;
    private String name;
    private String tel;
    private String address;
    private String zipcode;
    private Double lat, lng;
}
