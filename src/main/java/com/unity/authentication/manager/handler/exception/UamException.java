package com.unity.authentication.manager.handler.exception;

/**
 * Created by xuhelaw on 2020/10/18.
 */
public class UamException extends Exception {
    private String errorCode;

    public UamException(String errorCode,String message){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return errorCode;
    }

}
