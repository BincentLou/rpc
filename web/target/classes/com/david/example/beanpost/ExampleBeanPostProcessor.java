package com.david.example.beanpost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/10/12 10:03 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的bean初始化处理器
 * @since 1.0
 **/
@Component
public class ExampleBeanPostProcessor implements BeanPostProcessor {

    Logger logger = LoggerFactory.getLogger(ExampleBeanPostProcessor.class);

    public ExampleBeanPostProcessor() {
        this.logger.info("--------创建beanPostProcessor");
        StringBuilder sb = new StringBuilder();
        for(StackTraceElement stackTraceElement:new Exception().getStackTrace()){
            sb.append(stackTraceElement.toString());
            sb.append(System.lineSeparator());
        }
        logger.info(sb.toString());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("--------------开始处理beanpostprocess"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
