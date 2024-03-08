package com.example.salesdemo.Commons.ExceptionHandler;

import com.example.salesdemo.Commons.utils.ResponseUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.QueryTypeMismatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler extends Throwable {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> CustomExceptionHandler(UserException userException) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(userException);
        return response;

    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Object> CustomExceptionHandler(InvalidFormatException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }

    @ExceptionHandler(QueryTypeMismatchException.class)
    public ResponseEntity<Object> CustomExceptionHandler(QueryTypeMismatchException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> CustomExceptionHandler(NullPointerException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;

    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> CustomExceptionHandler(NumberFormatException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;

    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<Object> CustomExceptionHandler(IndexOutOfBoundsException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> CustomExceptionHandler(HttpMessageNotReadableException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> CustomExceptionHandler(MissingServletRequestParameterException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> CustomExceptionHandler(HttpRequestMethodNotSupportedException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> CustomExceptionHandler(IllegalArgumentException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> CustomExceptionHandler(IllegalStateException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> CustomExceptionHandler(EntityNotFoundException exception) {
        ResponseEntity<Object> response = ResponseUtil.returnResponse(exception);
        return response;
    }


}
