package com.works.reed.domain.attendance.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttendanceCodeType {

    QRCODE("QRCODE"), NFC("NFC");

    private String key;
    
}
