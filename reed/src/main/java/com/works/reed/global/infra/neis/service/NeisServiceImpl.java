package com.works.reed.global.infra.neis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.reed.global.common.dto.response.PageResponse;
import com.works.reed.global.infra.neis.config.NeisProperties;
import com.works.reed.global.infra.neis.dto.request.NeisSchoolInfoRequest;
import com.works.reed.global.infra.neis.dto.request.NeisSchoolScheduleRequest;
import com.works.reed.global.infra.neis.dto.response.info.SchoolInfo;
import com.works.reed.global.infra.neis.dto.response.info.SchoolInfoResponse;
import com.works.reed.global.infra.neis.dto.response.schedule.SchoolSchedule;
import com.works.reed.global.infra.neis.dto.response.schedule.SchoolScheduleResponse;
import com.works.reed.global.infra.neis.exception.NeisJsonException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class NeisServiceImpl implements NeisService {

    private final RestTemplate restTemplate;
    private final NeisProperties neisProperties;

    public PageResponse getSchoolInfo(NeisSchoolInfoRequest request) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(uriComponentSchoolInfo(request), String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                SchoolInfoResponse schoolInfoResponse = new ObjectMapper().readValue(response.getBody(), SchoolInfoResponse.class);
                SchoolInfo schoolInfo = schoolInfoResponse.getSchoolInfo().get(1);
                return new PageResponse(schoolInfo.getRow(), schoolInfoResponse.getSchoolInfo().get(0).head.get(0).getList_total_count());
            }
        } catch (Exception e) {
            throw NeisJsonException.EXCEPTION;
        }
        return null;
    }

    public PageResponse getSchoolSchedule(NeisSchoolScheduleRequest request) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(uriComponentSchoolSchedule(request), String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                SchoolScheduleResponse schoolScheduleResponse = new ObjectMapper().readValue(response.getBody(), SchoolScheduleResponse.class);
                SchoolSchedule schoolSchedule = schoolScheduleResponse.getSchoolInfo().get(1);
                return new PageResponse(schoolSchedule.getRow(), schoolScheduleResponse.getSchoolInfo().get(0).head.get(0).getList_total_count());
            }
        } catch (Exception e) {
            throw NeisJsonException.EXCEPTION;
        }
        return null;
    }

    private URI uriComponentSchoolInfo(NeisSchoolInfoRequest request) {
        String url = neisProperties.getBaseUrl() + "/schoolInfo";
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("SCHUL_NM", request.getSchoolName())
                .queryParam("Type", "json")
                .queryParam("pIndex", String.valueOf(request.getPage()))
                .queryParam("pSize", String.valueOf(request.getSize()))
                .queryParam("key", neisProperties.getKey())
                .encode()
                .build().toUri();
    }

    private URI uriComponentSchoolSchedule(NeisSchoolScheduleRequest request) {
        String url = neisProperties.getBaseUrl() + "/SchoolSchedule";
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("ATPT_OFCDC_SC_CODE", request.getAtptOfcdcScCode())
                .queryParam("SD_SCHUL_CODE", request.getSdSchulCode())
                .queryParam("AA_YMD", request.getDate())
                .queryParam("Type", "json")
                .queryParam("pIndex", String.valueOf(request.getPage()))
                .queryParam("pSize", String.valueOf(request.getSize()))
                .queryParam("key", neisProperties.getKey())
                .encode()
                .build().toUri();
    }
}
