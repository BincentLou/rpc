package com.david.example;

import com.david.example.ExampleQuartz;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2019/9/16 10:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:定时任务配置
 * @since 1.0
 **/
@Configuration
public class ExampleQuartzConfig {
//
//    @Bean
//    public JobDetail jobDetail(){
//        return JobBuilder.newJob(ExampleQuartz.class).withIdentity("exampleQuartz").usingJobData("msg","简单的定时任务").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger trigger(){
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("exampleQuartzTrigger").withSchedule(cronScheduleBuilder).build();
//    }
}
