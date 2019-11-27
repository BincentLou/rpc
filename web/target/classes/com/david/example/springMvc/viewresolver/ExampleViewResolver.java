package com.david.example.springMvc.viewresolver;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @version $Id: null.java, v 1.0 2019/8/27 11:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: provides mapping between  view name and actual views,如果order越大，越晚执行，必须默认配置InternalResourceViewResolver 在chain最后
 * @since 1.0
 **/
@Order(1)
public class ExampleViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        // 被 dispatcherServlet 调用，链式处理，返回null表示未成功处理，交给chain 继续处理
        return null;
    }
}
