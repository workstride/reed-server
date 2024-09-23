package com.works.reed.domain.member.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class DuplicateEmailException extends CustomException {
    public DuplicateEmailException() {
        super(HttpStatus.BAD_REQUEST, "이미 등록된 이메일");
    }

    public static final CustomException EXCEPTION = new DuplicateEmailException();
}
