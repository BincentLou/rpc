package com.david.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

/**
 * @version $Id: null.java, v 1.0 2019/9/15 10:01 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:线程池 控制器
 * @since 1.0
 **/
@RestController
@Validated
public class ExampleExecutorController {

    private Logger logger = LoggerFactory.getLogger(ExampleJdbcController.class);

    @RequestMapping("/asynctask/{message}")
    public String asyncTask(@PathVariable @Size(min = 5,max = 15) String message) {
        println(message);
        return "ok";
    }

    @Async
    public void println(String message){
        logger.info("异步执行任务  输出消息:{}",message);
    }
}
