package com.zero.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 通用异常处理器
*/
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }

}
