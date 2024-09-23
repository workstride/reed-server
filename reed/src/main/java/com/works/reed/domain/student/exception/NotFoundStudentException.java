package com.works.reed.domain.student.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundStudentException extends CustomException {
    public NotFoundStudentException() {
        super(HttpStatus.BAD_REQUEST, "잘못된 학생 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundStudentException();
}
