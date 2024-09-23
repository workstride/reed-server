package com.works.reed.global.infra.neis.dto.response.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SchoolScheduleResponse {
    @JsonProperty("SchoolSchedule")
    public List<SchoolSchedule> getSchoolInfo() {
        return this.SchoolSchedule;
    }
    public void setSchoolInfo(List<SchoolSchedule> SchoolSchedule) {
        this.SchoolSchedule = SchoolSchedule;
    }
    public List<SchoolSchedule> SchoolSchedule;
}