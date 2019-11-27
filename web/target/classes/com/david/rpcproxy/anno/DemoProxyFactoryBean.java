package com.david.rpcproxy.anno;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @version $Id: null.java, v 1.0 2019/11/21 3:34 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的代理工厂
 * @since 1.0
 **/
public class DemoProxyFactoryBean implements FactoryBean , ApplicationContextAware {
    private ApplicationContext applicationContext;

    private String name;

    private String url;

    private Class type;

    @Override
    public Object getObject(){
        BaiduHttpClient baiduHttpClient = applicationContext.getBean(BaiduHttpClient.class);
        return getEnhancher(baiduHttpClient,type);
    }

    private Object getEnhancher(BaiduHttpClient baiduHttpClient, Class type) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{type});
        enhancer.setCallback(new DemoRPCMethodIntercept(baiduHttpClient));
        return enhancer.create();
    }

    @Override
    public Class<?> getObjectType() {
        return DemoRpcBean.class;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getName() {
        return name;
    }

    public DemoProxyFactoryBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DemoProxyFactoryBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public Class getType() {
        return type;
    }

    public DemoProxyFactoryBean setType(Class type) {
        this.type = type;
        return this;
    }
}
