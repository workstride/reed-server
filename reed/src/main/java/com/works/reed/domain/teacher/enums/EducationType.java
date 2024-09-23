package com.works.reed.domain.teacher.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EducationType {
    HIGH_SCHOOL("고등학교"),
    JUNIOR_COLLEGE("2년제 대학"),
    UNIVERSITY("대학교"),
    GRADUATE_SCHOOL("대학원"),
    NON_PUBLIC("비공개");
    private final String value;
    @JsonValue
    public String getValue(){
        return value;
    }

}
