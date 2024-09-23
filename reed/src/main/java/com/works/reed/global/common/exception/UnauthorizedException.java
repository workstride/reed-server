package com.works.reed.global.common.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends CustomException {
    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED, "Unauthorized");
    }
    public static final CustomException EXCEPTION = new UnauthorizedException();
}
