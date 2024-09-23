package com.works.reed.global.infra.neis.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Head {
    @JsonProperty("list_total_count")
    public int getList_total_count() {
        return this.list_total_count;
    }

    public void setList_total_count(int list_total_count) {
        this.list_total_count = list_total_count;
    }

    int list_total_count;

    @JsonProperty("RESULT")
    public Result getRESULT() {
        return this.rESULT;
    }

    public void setRESULT(Result rESULT) {
        this.rESULT = rESULT;
    }

    Result rESULT;
}
