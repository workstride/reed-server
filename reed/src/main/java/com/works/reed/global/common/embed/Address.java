package com.works.reed.global.common.embed;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Embeddable
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 10)
    private String zipcode;

    @Column(nullable = false)
    private Double lat;

    @Column(nullable = false)
    private Double lng;

}
