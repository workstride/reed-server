package com.works.reed.domain.announcement.dao.querydsl;

import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnouncePageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceQueryRepository {
    Page<AnnounceInfo> findAnnounces(AnnouncePageRequest request);

}
