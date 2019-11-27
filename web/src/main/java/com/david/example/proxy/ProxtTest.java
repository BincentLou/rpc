package com.david.example.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version $Id: null.java, v 1.0 2019/9/12 4:28 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ProxtTest {
//
//    public static void main(String[] args){
//
        TargetInterface target = new TargetObj1();
//
//        Class<?>[] interfaces = target.getClass().getInterfaces();
//
//        TargetInterface targetProxy = (TargetInterface) StaticProxy.getProxyObj(target);
//
//        targetProxy.getName();
//
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", target.getClass().getInterfaces());
//        String path = "/Users/david/Desktop/技术资料/example/proxytest/Proxy0.txt";
//        try(FileOutputStream fos = new FileOutputStream(path)){
//            fos.write(classFile);
//            fos.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
