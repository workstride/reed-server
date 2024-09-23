package com.works.reed.domain.student.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class ExistStudentException extends CustomException {
    public ExistStudentException() {
        super(HttpStatus.BAD_REQUEST, "이미 등록된 학생 회원");
    }

    public static final CustomException EXCEPTION = new ExistStudentException();
}
