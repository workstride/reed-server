package com.works.reed.domain.academy.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundAcadTeacherException extends CustomException{
    public NotFoundAcadTeacherException() {
        super(HttpStatus.NOT_FOUND, "잘못된 학원 선생님 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundAcadTeacherException();
}
