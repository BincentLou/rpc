package com.david.example.springMvc.mvcconfig;

import com.david.example.springMvc.handlerintercepters.ExampleHandlerInterceptor;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2019/8/29 3:11 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:mvc的配置类
 * @since 1.0
 **/
@Configuration
public class ExampleMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ExampleHandlerInterceptor());
    }


//    /**
//     * 跟@ControllerAdvice冲突
//     * @param resolvers
//     */
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//        resolvers.add(new ExampleHandlerExceptionResolver());
//    }

    /**
     * 消息转换
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();
        jackson2ObjectMapperBuilder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).modulesToInstall(new ParameterNamesModule());
        converters.add(new MappingJackson2HttpMessageConverter(jackson2ObjectMapperBuilder.build()));
    }

    /**
     * 直接跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/aaaa","/hello");
    }

    /**
     * 公共资源家在
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/public","classpath:/static/").setCachePeriod(3155592);
    }

    /**
     * 结合hibernate的验证器，快速返回错误
     * @return
     */
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    /**
     * 跨域访问权限
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 全局配置跨域-也可以在controller一层进行class级别或者方法级别的 跨域控制，@
        registry.addMapping("/cros/**").allowedOrigins("http://localhost:8081/**").allowedMethods("POST","GET").allowedHeaders("age","sex","name").exposedHeaders("account","aName").allowCredentials(true).maxAge(3000);
    }
}
