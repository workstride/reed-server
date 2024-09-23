package com.works.reed.domain.academy.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundAcademyException extends CustomException{
    public NotFoundAcademyException() {
        super(HttpStatus.NOT_FOUND, "잘못된 학원 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundAcademyException();
}
