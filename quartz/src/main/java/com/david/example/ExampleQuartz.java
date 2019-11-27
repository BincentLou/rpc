package com.david.example;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @version $Id: null.java, v 1.0 2019/9/16 9:46 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ExampleQuartz extends QuartzJobBean {

    private static Logger logger = LoggerFactory.getLogger(ExampleQuartz.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String msg = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("msg");
        logger.info("定时任务：启动,收到消息:{}",msg);
    }
}
