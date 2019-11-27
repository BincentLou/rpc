package com.david.example.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2019/8/26 10:33 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class ExampleMessageSourceController {

    @Resource
    private MessageSource messageSource;

    @RequestMapping("/hello")
    public String hello(){
        return  getMessage("tips1");
    }

    private String getMessage(String code){
        return getMessage(code,null);
    }

    private String getMessage(String code,Object[] args){
        LocaleContextHolder.getLocale();
        return messageSource.getMessage(code,args, Locale.CHINA);
    }
}
