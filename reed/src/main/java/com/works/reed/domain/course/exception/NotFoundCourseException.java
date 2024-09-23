package com.works.reed.domain.course.exception;

import com.works.reed.global.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundCourseException extends CustomException {
    public NotFoundCourseException() {
        super(HttpStatus.BAD_REQUEST, "잘못된 수업 정보");
    }

    public static final CustomException EXCEPTION = new NotFoundCourseException();
}
