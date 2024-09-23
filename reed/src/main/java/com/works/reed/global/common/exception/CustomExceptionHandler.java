package com.works.reed.global.common.exception;

import com.works.reed.global.common.dto.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ExceptionResponse> handleCustomException(CustomException e) {
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResponse(e.getStatus().value(), e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponse> handleMethodArgument(MethodArgumentNotValidException e){
        return ResponseEntity.status(BAD_REQUEST).body(new ExceptionResponse(BAD_REQUEST.value(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<ExceptionResponse> handleException(BadCredentialsException e) {
        return ResponseEntity.status(UNAUTHORIZED).body(new ExceptionResponse(UNAUTHORIZED.value(), "BadCredentialsException"));
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    protected ResponseEntity<ExceptionResponse> handleBindException(ServletRequestBindingException e) {
        return ResponseEntity.status(BAD_REQUEST).body(new ExceptionResponse(BAD_REQUEST.value(), "ServletRequestBindingException"));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionResponse> handleException(Exception e) {
        return ResponseEntity.status(BAD_REQUEST).body(new ExceptionResponse(BAD_REQUEST.value(), "Exception"));
    }
}
