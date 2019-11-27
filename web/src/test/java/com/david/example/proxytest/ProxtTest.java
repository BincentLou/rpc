package com.david.example.proxytest;

import com.david.example.proxytest.hanche.EnhancerFactoryTest;
import com.david.example.proxytest.proxyhandle.ProxyFactoryTest;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @version $Id: null.java, v 1.0 2019/9/12 4:28 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:测试类
 * @since 1.0
 **/
public class ProxtTest {

    public static void main(String[] args){

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/david/Desktop/技术资料/demo");
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SelfInterface selfBean = new SelfBean();
        OtherBean otherBean = new OtherBean();
//        SelfInterface selfProxy = (SelfInterface) ProxyFactoryTest.getProxyObj(selfBean);
        SelfInterface selfEnchancher = (SelfInterface) EnhancerFactoryTest.getEnhancher(otherBean);
//        selfProxy.getName();
       System.out.println(selfEnchancher.getName());
    }
}
