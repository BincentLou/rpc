package com.david.example.listener;

import com.david.example.ExampleParentObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @version $Id: null.java, v 1.0 2019/8/22 10:43 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义spring事件监听器，在meta-inf/spring.factories中定义
 * @since 1.0
 **/
public class ExampleListener extends ExampleParentObj implements ApplicationListener, ApplicationContextAware {

    private ApplicationContext applicationContext;

    Logger logger = LoggerFactory.getLogger(ExampleListener.class);
    StringBuilder sb  = new StringBuilder();
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        sb.delete(0,sb.length());
        sb.append("----监听到Spring的事件:").append(event.toString()).append(System.lineSeparator());
        sb.append("----判断事件是本context发布:  ").append(this.applicationContext==event.getSource()).append(System.lineSeparator());
        sb.append("----发布者:   ").append(event.getSource()).append("类型: ").append(event.getSource().getClass()).append(System.lineSeparator());
        System.out.println(sb);

    }

    public ExampleListener() {
        printStack();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
