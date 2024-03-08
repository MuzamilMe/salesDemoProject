package com.example.salesdemo.Commons.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    /**
     * @param exception
     * @return response
     */
    public static ResponseEntity<Object> returnResponse(RuntimeException exception) {
        StatusDto statusDto = new StatusDto();
        statusDto.setCode(StatusEnum.FAILURE);
        statusDto.setMessage(exception.getMessage().replace("com.example.springboot_task2.Entities.", ""));
        exception.printStackTrace();
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    /**
     * @param exception
     * @return response
     */
    public static ResponseEntity<Object> returnResponse(Exception exception) {
        StatusDto statusDto = new StatusDto();
        statusDto.setCode(StatusEnum.FAILURE);
        statusDto.setMessage(exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    public static ResponseEntity<Object> returnResponseWithCustomMessage(Integer code, String message, Object data) {
        StatusDto statusDto = new StatusDto();
        statusDto.setCode(StatusEnum.SUCCESS);
        statusDto.setMessage(message);
        statusDto.setData(data);

        return new ResponseEntity<>(statusDto, HttpStatus.valueOf(code));
    }

    public static ResponseEntity<Object> returnResponseWithCustomMessage(int code, String message, Object data1, Object data) {
        StatusDto2 statusDto = new StatusDto2();
        statusDto.setCode(StatusEnum.SUCCESS);
        statusDto.setMessage(message);
        statusDto.setData(data);
        statusDto.setData1(data1);
        return new ResponseEntity<>(statusDto, HttpStatus.valueOf(code));
    }

    /**
     * Handle Validation exception
     *
     * @param ex
     * @return response of validation errors
     */

    /**
     * Will return All errors with field and their messages
     *
     * @param bindingResult
     * @return List of FieldErrors

     */

    /**
     * @param object
     * @return response
     */
    public static ResponseEntity<Object> returnResponse(Object object) {
        StatusDto statusDto = new StatusDto();
        statusDto.setCode(StatusEnum.SUCCESS);
        statusDto.setMessage(StatusEnum.SUCCESS.getReasonPhrase());
        statusDto.setData(object);
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    /**
     * @param statusDto
     * @return response
     */
    public static ResponseEntity<Object> returnResponse(StatusDto statusDto) {
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

}
