package com.works.reed.domain.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    STUDENT("ROLE_STUDENT"),
    PARENT("ROLE_PARENT"),
    TEACHER("ROLE_TEACHER"),
    HEAD_TEACHER("ROLE_HEAD_TEACHER"),
    MANAGER("ROLE_MANGER"),
    ADMIN("ROLE_ADMIN");
    private final String key;
}