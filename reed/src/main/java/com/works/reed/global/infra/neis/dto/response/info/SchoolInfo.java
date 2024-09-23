package com.works.reed.global.infra.neis.dto.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.works.reed.global.infra.neis.dto.response.Head;

import java.util.List;

public class SchoolInfo {
    public List<Head> head;
    public List<SchoolDetailInfo> row;
    @JsonProperty("head")
    public List<Head> getHead() {
        return this.head;
    }
    public void setHead(List<Head> head) {
        this.head = head;
    }
    @JsonProperty("row")
    public List<SchoolDetailInfo> getRow() {
        return this.row;
    }
    public void setRow(List<SchoolDetailInfo> row) {
        this.row = row;
    }
}
