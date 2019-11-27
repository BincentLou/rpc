package com.david.example.springMvc.filters;

import org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2019/8/29 9:40 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:过滤器配置
 * @since 1.0
 **/
@Configuration
public class ExampleFiltersConfig {

    @Bean
    public OrderedHttpPutFormContentFilter orderedHttpPutFormContentFilter(){
        //把request请求或者delete等请求的参数 使ServletRequest.getParameter*()能够获取
        return new OrderedHttpPutFormContentFilter();
    }

    @Bean
    public ExampleFilter exampleFilter(){
        return new ExampleFilter();
    }
}
