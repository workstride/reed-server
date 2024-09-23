package com.works.reed.domain.parent.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundParentException extends CustomException {
    public NotFoundParentException() {
        super(HttpStatus.BAD_REQUEST, "잘못된 보호자 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundParentException();
}
