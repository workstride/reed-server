package com.works.reed.global.infra.neis.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NeisJsonException extends CustomException {
    public NeisJsonException() {
        super(HttpStatus.BAD_REQUEST, "Neis API error");
    }

    public static final CustomException EXCEPTION = new NeisJsonException();
}
