package com.david.example.factorypost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/10/12 10:08 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的beanfactory后处理起
 * @since 1.0
 **/
@Component
public class ExampleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    Logger logger = LoggerFactory.getLogger(ExampleBeanFactoryPostProcessor.class);

    public ExampleBeanFactoryPostProcessor() {
        logger.info("----------创建beanFactory post processor");
        StringBuilder sb = new StringBuilder();
        for(StackTraceElement stackTraceElement:new Exception().getStackTrace()){
            sb.append(stackTraceElement.toString());
            sb.append(System.lineSeparator());
        }
        logger.info(sb.toString());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("------------开始处理beanfatory");
    }
}
