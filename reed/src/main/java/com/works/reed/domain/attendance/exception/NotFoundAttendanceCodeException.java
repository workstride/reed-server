package com.works.reed.domain.attendance.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundAttendanceCodeException extends CustomException {
    public NotFoundAttendanceCodeException() {
        super(HttpStatus.BAD_REQUEST, "잘못된 출석 코드");
    }

    public static final CustomException EXCEPTION = new NotFoundAttendanceCodeException();
}
