package com.david.example.springMvc.initializer;

import com.david.example.springMvc.filters.ExampleFiltersConfig;
import com.david.example.springMvc.handlerintercepters.ExampleHandlerInterceptorConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * servlet3 中配置Springmvc的基本入口
 * @version $Id: null.java, v 1.0 2019/8/28 10:36 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义的 webApplicationContext 配置 如果没有context继承，那就直接在rootConfig直接返回所有配置，在servletConfig返回null
 * @since 1.0
 **/
@Component
public class ExampleDispatcherServletInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ExampleFiltersConfig.class, ExampleHandlerInterceptorConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }

    /**
     * 配置mutilpart resolver的参数，需要配合一个MutilpartResolver类型的@Conpoment bean使用
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/temp"));
        super.customizeRegistration(registration);
    }
}
