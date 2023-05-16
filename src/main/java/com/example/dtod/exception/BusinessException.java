package com.example.dtod.exception;

import com.example.dtod.response.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}

