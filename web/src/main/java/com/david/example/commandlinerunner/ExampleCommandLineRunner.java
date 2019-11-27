package com.david.example.commandlinerunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/8/23 3:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:application.run完成之前调用即在applicationStaredEvent之后 ApplicationReadyEvent事件之前
 * @since 1.0
 **/
@Order(1)//多个runner必须排序
@Component
public class ExampleCommandLineRunner implements CommandLineRunner {

    Logger loggger = LoggerFactory.getLogger(ExampleCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        loggger.info("example command line runner run");
    }
}
