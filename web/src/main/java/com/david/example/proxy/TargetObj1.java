package com.david.example.proxy;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 7:25 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:实际的对象
 * @since 1.0
 **/
public class TargetObj1 implements TargetInterface{
    @Override
    public String getName() {
        return "target object 1";
    }
}
