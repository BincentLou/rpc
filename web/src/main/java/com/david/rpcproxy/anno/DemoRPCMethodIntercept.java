package com.david.rpcproxy.anno;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @version $Id: null.java, v 1.0 2019/11/21 3:58 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:方法代理
 * @since 1.0
 **/
public class DemoRPCMethodIntercept implements MethodInterceptor {

    private HttpClient httpClient;

    public DemoRPCMethodIntercept(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        return httpClient.getSend(params);
    }
}
