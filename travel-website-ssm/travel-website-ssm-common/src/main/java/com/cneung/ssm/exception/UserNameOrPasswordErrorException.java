package com.cneung.ssm.exception;

/**
 * 密码错误异常
 */
public class UserNameOrPasswordErrorException extends Exception {
    public UserNameOrPasswordErrorException(){

    }
    public UserNameOrPasswordErrorException(String errorMsg){
        super(errorMsg);
    }
}
