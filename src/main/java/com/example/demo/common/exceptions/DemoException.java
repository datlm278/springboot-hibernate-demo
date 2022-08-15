package com.example.demo.common.exceptions;

import com.example.demo.common.enums.EnumException;

import java.util.List;

public class DemoException extends RuntimeException{
    private EnumException enumException;
    private List<String> msgParams;

    private Exception ex;

    public DemoException(EnumException enumException, List<String> msgParams) {
        this.enumException = enumException;
        this.msgParams = msgParams;
    }

    public DemoException(EnumException enumException) {
        this.enumException = enumException;
        this.msgParams = null;
    }

    public DemoException(EnumException enumException, Exception exception) {
        this.enumException = enumException;
        this.msgParams = null;
        this.ex = exception;
    }
}
