package com.david.example.proxytest.proxyhandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 7:24 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:jdk代理工厂类
 * @since 1.0
 **/
public class ProxyFactoryTest {
    public static Object getProxyObj(Object targetObj){
        MyInvocationHandler invocation = new MyInvocationHandler(targetObj);
        return  Proxy.newProxyInstance(targetObj.getClass().getInterfaces()[0].getClassLoader(),new Class[]{ targetObj.getClass().getInterfaces()[0]}, invocation);
    }
}
