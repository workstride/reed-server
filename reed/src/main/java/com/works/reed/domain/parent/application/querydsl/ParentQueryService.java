package com.works.reed.domain.parent.application.querydsl;

import com.works.reed.domain.parent.dto.ParentInfo;

import java.util.List;

public interface ParentQueryService {
    List<ParentInfo> findParentsByChildId(Long memberId);
}
