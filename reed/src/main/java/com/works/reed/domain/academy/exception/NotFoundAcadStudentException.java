package com.works.reed.domain.academy.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundAcadStudentException extends CustomException{
    public NotFoundAcadStudentException() {
        super(HttpStatus.NOT_FOUND, "잘못된 학원 학생 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundAcadStudentException();
}
