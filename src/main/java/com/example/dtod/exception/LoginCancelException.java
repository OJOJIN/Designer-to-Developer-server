package com.example.dtod.exception;


import com.example.dtod.response.ErrorMessage;

public class LoginCancelException extends BusinessException{

    public LoginCancelException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
