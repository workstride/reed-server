package com.works.reed.domain.teacher.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class ExistTeacherException extends CustomException {
    public ExistTeacherException() {
        super(HttpStatus.BAD_REQUEST, "이미 등록된 선생님 회원");
    }

    public static final CustomException EXCEPTION = new ExistTeacherException();
}
