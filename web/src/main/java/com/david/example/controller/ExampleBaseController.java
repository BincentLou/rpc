package com.david.example.controller;

import com.alibaba.fastjson.JSON;
import com.david.example.DTO.OtherQuest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.StreamSupport;

/**
 * @version $Id: null.java, v 1.0 2019/8/19 10:48 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class ExampleBaseController implements ApplicationContextAware {

    Logger logger = LoggerFactory.getLogger(ExampleBaseController.class);

    private ApplicationContext applicationContext;

    @Value("${appName}")
    private String appName;

    @Value("${profile}")
    private String profile;

    @Autowired
    private ExitCodeGenerator exitCodeGenerator;

    @RequestMapping("/")
    public String home(){
        return "hello world";
    }

    @RequestMapping("/arguments")
    public String arguments(){
        StringBuilder str = new StringBuilder();

        StreamSupport.stream(applicationArguments.getOptionNames().spliterator(),false).forEach(item->str.append(item));
        return str.toString();
    }
    @RequestMapping("/shutdown")
    public String shutdown(){
        logger.info("退出服务");
        SpringApplication.exit(applicationContext,exitCodeGenerator);
        return "退出完成";
    }

    @RequestMapping("/appName")
    public String appName(){
        return this.appName;
    }

   @RequestMapping("/profile")
    public String profile(){
        return this.profile;
    }

    @RequestMapping("/localserverport")
    public String localserverport(){

        return applicationContext.getEnvironment().getProperty("local.server.port");
    }

    @RequestMapping("/posttest")
    public OtherQuest postTest(@Valid @RequestBody OtherQuest request){
        logger.info("收到消息："+ JSON.toJSONString(request));
        return request;
    }
    @Autowired
    ApplicationArguments applicationArguments;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
