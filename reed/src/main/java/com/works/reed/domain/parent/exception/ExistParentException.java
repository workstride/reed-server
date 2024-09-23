package com.works.reed.domain.parent.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class ExistParentException extends CustomException {
    public ExistParentException() {
        super(HttpStatus.BAD_REQUEST, "이미 등록된 보호자의 자녀");
    }

    public static final CustomException EXCEPTION = new ExistParentException();
}
