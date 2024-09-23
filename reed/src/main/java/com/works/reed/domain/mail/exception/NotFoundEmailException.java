package com.works.reed.domain.mail.exception;

import com.works.reed.domain.member.exception.DuplicateEmailException;
import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundEmailException extends CustomException {
    public NotFoundEmailException() {
        super(HttpStatus.NOT_FOUND, "이메일이 존재하지 않음");
    }

    public static final CustomException EXCEPTION = new NotFoundEmailException();
}
