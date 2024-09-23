package com.works.reed.domain.announcement.application.querydsl;

import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnouncePageRequest;
import com.works.reed.global.common.dto.response.PageResponse;

import java.util.List;

public interface AnnounceQueryService {
    PageResponse<List<AnnounceInfo>> findAnnounces(AnnouncePageRequest request);

}
