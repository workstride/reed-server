package com.works.reed.global.infra.neis.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("CODE")
    public String getCODE() {
        return this.cODE;
    }

    public void setCODE(String cODE) {
        this.cODE = cODE;
    }

    String cODE;

    @JsonProperty("MESSAGE")
    public String getMESSAGE() {
        return this.mESSAGE;
    }

    public void setMESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }

    String mESSAGE;
}


