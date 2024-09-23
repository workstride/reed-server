package com.works.reed.domain.parent.dao.querydsl;

import com.works.reed.domain.parent.dto.ParentInfo;

import java.util.List;

public interface ParentQueryRepository {
    List<ParentInfo> findParentsByChildId(Long memberId);
}
