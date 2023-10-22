package com.example.apprestbasic.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessException extends Exception{

    public BusinessException(String message) {
        super(message);
    }
}
