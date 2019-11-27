package com.david.example.proxy;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 7:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class TargetObj2 implements TargetInterface{
    @Override
    public String getName() {
        return "target Object 2";
    }
}
