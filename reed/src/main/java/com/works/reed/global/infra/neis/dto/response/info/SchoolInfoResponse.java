package com.works.reed.global.infra.neis.dto.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SchoolInfoResponse {
    @JsonProperty("schoolInfo")
    public List<SchoolInfo> getSchoolInfo() {
        return this.schoolInfo;
    }
    public void setSchoolInfo(List<SchoolInfo> schoolInfo) {
        this.schoolInfo = schoolInfo;
    }
    public List<SchoolInfo> schoolInfo;
}



