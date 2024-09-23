package com.works.reed.domain.attendance.api;

import com.works.reed.domain.attendance.application.AttendanceService;
import com.works.reed.domain.attendance.dto.request.AttendanceCodeRequest;
import com.works.reed.domain.attendance.dto.request.AttendanceRequest;
import com.works.reed.domain.attendance.dto.response.AttendanceCodeResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "출석", description = "출석")
@SecurityRequirement(name = "BearerAuthentication")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/qrcode")
    public void attendanceQRcode(@Validated @RequestBody AttendanceRequest request) {
        attendanceService.attendanceQRcode(request.getCode());
    }

    @PostMapping("/nfc")
    public void attendanceNfc(@Validated @RequestBody AttendanceRequest request) {
        attendanceService.attendanceNFC(request.getCode());
    }

    @PostMapping("/generate/qrcode")
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceCodeResponse generateQRCode(@Validated @RequestBody AttendanceCodeRequest request) {
        return attendanceService.generateQRCode(request.toAttendanceCode());
    }


}
