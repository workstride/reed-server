package com.works.reed.domain.academy.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class ExistAcadStudentException extends CustomException {
    public ExistAcadStudentException() {
        super(HttpStatus.BAD_REQUEST, "이미 학원에 등록된 학생 회원");
    }

    public static final CustomException EXCEPTION = new ExistAcadStudentException();
}
