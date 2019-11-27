package com.david.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/9/2 3:44 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
@RestController
public class ExampleExceptionController {

    @RequestMapping("/exception")
    public String exception(){
        throw new IllegalArgumentException("出错喽");
    }
}
