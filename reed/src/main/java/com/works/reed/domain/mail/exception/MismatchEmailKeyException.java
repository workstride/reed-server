package com.works.reed.domain.mail.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class MismatchEmailKeyException extends CustomException {
    public MismatchEmailKeyException() {
        super(HttpStatus.UNAUTHORIZED, "이메일 인증키가 일치하지 않음");
    }

    public static final CustomException EXCEPTION = new MismatchEmailKeyException();
}
