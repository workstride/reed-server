package com.works.reed.domain.announcement.application;

import com.works.reed.domain.announcement.dto.Announce;
import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnounceRequest;

import java.util.List;

public interface AnnounceService {
    void upload(AnnounceRequest announce);
    AnnounceInfo read(Long id);
    void edit(AnnounceRequest request, Long id);
    void delete(Long id);
}
