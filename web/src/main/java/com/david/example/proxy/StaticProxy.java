package com.david.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 7:24 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class StaticProxy {

    public static Object getProxyObj(Object targetObj){

      return   Proxy.newProxyInstance(targetObj.getClass().getInterfaces()[0].getClassLoader(),new Class[]{ targetObj.getClass().getInterfaces()[0]}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getDeclaringClass() instanceof Object){
                   return method.invoke(targetObj,args);
                }else{
                    account();
                    return method.invoke(targetObj,args);
                }
            }
        });
    }

    public static void account(){
        System.out.println("我使用了代理，接下来调用真正的对象");
    }
}
