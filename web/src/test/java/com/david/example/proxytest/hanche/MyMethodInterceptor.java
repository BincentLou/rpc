package com.david.example.proxytest.hanche;

import com.david.example.proxytest.OtherBean;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Method;

/**
 * @version $Id: null.java, v 1.0 2019/10/31 4:29 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的环绕
 * @since 1.0
 **/
public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * 增强实现
     * @param proxy
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */

    private OtherBean otherBean;

    public OtherBean getOtherBean() {
        return otherBean;
    }

    public MyMethodInterceptor(OtherBean otherBean) {
        this.otherBean = otherBean;
    }

    public MyMethodInterceptor setOtherBean(OtherBean otherBean) {
        this.otherBean = otherBean;
        return this;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        beforeProxy();
        String result = otherBean.getName();
//        Object result = methodProxy.invokeSuper(proxy, args);
//        Object result =  methodProxy.invoke(proxy,args);
//        afterProxy();
        return result;
    }

    private void beforeProxy() {
        System.out.println("before Enhancer");
    }

    private void afterProxy() {
        System.out.println("after Enhancer");
    }
}
