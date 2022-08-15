package com.example.demo.common.enums;

import org.springframework.http.HttpStatus;

public enum EnumException {

    EMPLOYEE_NOT_EXIST("EMPLOYEE_NOT_EXIST", HttpStatus.NOT_FOUND, "employee.not-exist", "employee isn't exist");

    private String errorCode;
    private HttpStatus httpStatus;
    private String messageKey;
    private String messageDefault;

    EnumException(String errorCode, HttpStatus httpStatus, String messageKey, String messageDefault) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.messageKey = messageKey;
        this.messageDefault = messageDefault;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String getMessageDefault() {
        return messageDefault;
    }

    @Override
    public String toString() {
        return "EnumCommonException{" +
                "errorCode='" + errorCode + '\'' +
                ", httpStatus=" + httpStatus +
                ", messageKey='" + messageKey + '\'' +
                ", messageDefault='" + messageDefault + '\'' +
                '}';
    }
}
