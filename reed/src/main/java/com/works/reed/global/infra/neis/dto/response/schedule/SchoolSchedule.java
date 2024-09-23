package com.works.reed.global.infra.neis.dto.response.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.works.reed.global.infra.neis.dto.response.Head;

import java.util.List;

public class SchoolSchedule {
    public List<Head> head;
    public List<SchoolDetailSchedule> row;

    @JsonProperty("head")
    public List<Head> getHead() {
        return this.head;
    }

    public void setHead(List<Head> head) {
        this.head = head;
    }

    @JsonProperty("row")
    public List<SchoolDetailSchedule> getRow() {
        return this.row;
    }

    public void setRow(List<SchoolDetailSchedule> row) {
        this.row = row;
    }
}
