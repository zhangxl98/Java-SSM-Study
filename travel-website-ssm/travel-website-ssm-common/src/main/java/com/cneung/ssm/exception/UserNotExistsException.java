package com.cneung.ssm.exception;

/**
 * 用户不存在异常
 */
public class UserNotExistsException extends Exception {
    public UserNotExistsException(){

    }
    public UserNotExistsException(String errorMsg){
        super(errorMsg);
    }
}
