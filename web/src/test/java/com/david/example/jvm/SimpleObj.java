package com.david.example.jvm;

/**
 * @version $Id: null.java, v 1.0 2019/12/18 5:22 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class SimpleObj {
    private String name;

    public String getName(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name;
    }
}
