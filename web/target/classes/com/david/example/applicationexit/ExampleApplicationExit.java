package com.david.example.applicationexit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2019/8/23 3:25 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:系统退出之前会
 * @since 1.0
 **/
@Configuration
public class ExampleApplicationExit implements  ExitCodeGenerator{

    private Logger logger = LoggerFactory.getLogger(ExitCodeGenerator.class);
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
       return new ExampleApplicationExit();
    }

    @Override
    public int getExitCode() {
        logger.info("application 退出，返回状态序号");
        return 44;
    }
}
