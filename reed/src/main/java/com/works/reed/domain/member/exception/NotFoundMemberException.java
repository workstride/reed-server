package com.works.reed.domain.member.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundMemberException extends CustomException {
    public NotFoundMemberException() {
        super(HttpStatus.NOT_FOUND, "잘못된 회원 정보");
    }
    public static final CustomException EXCEPTION = new NotFoundMemberException();
}
