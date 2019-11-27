package com.david.example.proxy;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 7:32 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class ExampleProxyController {

    private static Object obj = StaticProxy.getProxyObj(new TargetObj1());

    @RequestMapping("/proxy/{targetClass}")
    public String proxytest(@PathVariable String targetClass) throws ClassNotFoundException {
        Class<?> targetObj = Class.forName(targetClass);
        TargetInterface proxyObj = (TargetObj1) StaticProxy.getProxyObj(obj);
        obj = proxyObj;
        return proxyObj.getName();
    }

}
