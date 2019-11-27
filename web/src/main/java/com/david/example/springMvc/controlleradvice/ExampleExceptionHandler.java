package com.david.example.springMvc.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @version $Id: null.java, v 1.0 2019/8/28 10:32 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:@Controller 或者@ControllerAdvice的异常处理类
 * @since 1.0
 **/
@RestControllerAdvice
public class ExampleExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> IllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<String>("错了."+e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> ConstraintViolationException(IllegalArgumentException e){
        return new ResponseEntity<String>("错了."+e.getMessage(), HttpStatus.OK);
    }
}
