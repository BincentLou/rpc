package com.david.example.proxytest.hanche;

import com.david.example.proxytest.OtherBean;
import com.david.example.proxytest.SelfInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @version $Id: null.java, v 1.0 2019/10/28 10:33 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:工厂类
 * @since 1.0
 **/
public class EnhancerFactoryTest {
    /**
     * 生成新的代理
     * @param obj
     * @return
     */
    public static Object getEnhancher(Object obj) {
        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(obj.getClass());
        enhancer.setInterfaces(new Class[]{SelfInterface.class});
        MethodInterceptor callBack =new MyMethodInterceptor((OtherBean) obj);
        enhancer.setCallback(callBack);
        enhancer.setUseFactory(false);
        enhancer.setUseCache(true);
        return enhancer.create();
    }
}
