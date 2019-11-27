package com.david.example;

/**
 * @version $Id: null.java, v 1.0 2019/10/13 9:39 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:基本的父类
 * @since 1.0
 **/
public class ExampleParentObj {

    StringBuilder sb = new StringBuilder();

    protected void printStack() {
        sb.delete(0,sb.length());
        for (StackTraceElement stackTraceElement:new Exception().getStackTrace()){
            sb.append(stackTraceElement.toString()).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

}
