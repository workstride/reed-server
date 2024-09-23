package com.works.reed.domain.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderType {
    MALE("MALE"),
    FEMALE("FEMALE");
    private final String gender;
}

