package com.david.rpcproxy;

import com.david.rpcproxy.anno.EnableDemoAnno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version $Id: null.java, v 1.0 2019/11/22 5:08 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@EnableDemoAnno
@SpringBootApplication(scanBasePackages = {"com.david.rpcproxy"})
public class DemoApplication {
    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }
}
