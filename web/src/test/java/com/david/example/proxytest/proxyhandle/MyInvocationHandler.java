package com.david.example.proxytest.proxyhandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version $Id: null.java, v 1.0 2019/10/31 4:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的环绕
 * @since 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object originBean;

    public MyInvocationHandler(Object originBean) {
        this.originBean = originBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeProxy();
        Object result = method.invoke(originBean, args);
        afterProxy();
        return result;
    }

    private void afterProxy() {
        System.out.println("after proxy");
    }

    private void beforeProxy() {
        System.out.println("before proxy");
    }
}
