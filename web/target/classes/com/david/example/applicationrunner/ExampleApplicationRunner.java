package com.david.example.applicationrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/8/23 3:13 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:在application.run完成之前调用 ApplicationStrartedEvent 事件之后  ApplicationReadyEvent事件之前
 * @since 1.0
 **/
@Order(1)//多个runner必须要排序
@Component
public class ExampleApplicationRunner implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(ExampleApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("exampleApplicationRunner run");
    }
}
