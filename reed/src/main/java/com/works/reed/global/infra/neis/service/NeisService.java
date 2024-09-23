package com.works.reed.global.infra.neis.service;

import com.works.reed.global.common.dto.response.PageResponse;
import com.works.reed.global.infra.neis.dto.request.NeisSchoolInfoRequest;
import com.works.reed.global.infra.neis.dto.request.NeisSchoolScheduleRequest;

public interface NeisService {
    PageResponse getSchoolInfo(NeisSchoolInfoRequest request);
    PageResponse getSchoolSchedule(NeisSchoolScheduleRequest request);
}
