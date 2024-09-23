package com.works.reed.domain.teacher.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundTeacherException extends CustomException {
    public NotFoundTeacherException() {
        super(HttpStatus.BAD_REQUEST, "잘못된 선생님 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundTeacherException();
}
