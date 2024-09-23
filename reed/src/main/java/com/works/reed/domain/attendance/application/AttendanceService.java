package com.works.reed.domain.attendance.application;

import com.works.reed.domain.attendance.dto.AttendanceCode;
import com.works.reed.domain.attendance.dto.response.AttendanceCodeResponse;

public interface AttendanceService {
    void attendanceQRcode(String code);

    void attendanceNFC(String tag);

    AttendanceCodeResponse generateQRCode(AttendanceCode attendanceCode);
}
