package com.works.reed.domain.announcement.application.querydsl;

import com.works.reed.domain.announcement.dao.querydsl.AnnounceQueryRepository;
import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnouncePageRequest;
import com.works.reed.global.common.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AnnounceQueryServiceImpl implements AnnounceQueryService {

    private final AnnounceQueryRepository announceQueryRepository;

    @Override
    public PageResponse<List<AnnounceInfo>> findAnnounces(AnnouncePageRequest request) {
        Page<AnnounceInfo> result = announceQueryRepository.findAnnounces(request);
        return new PageResponse<List<AnnounceInfo>>(result.toList(), result.getTotalPages());
    }
}
