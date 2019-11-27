package com.david.example.springMvc.handlerintercepters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version $Id: null.java, v 1.0 2019/8/27 10:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: spring mvc special bean
 * @since 1.0
 **/
@Order(5)
public class ExampleHandlerInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(ExampleHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查权限，打印日志，修改header属性 在handler处理request之前，return false，break chain。被HandlerExecutionChain类调用
        logger.info("-----ExampleHandlerInterceptor 开始执行前处理");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //修改header属性 在handler处理request之后，对@ResponseBody 注解和 ResponseEntity 无效 可以继承 @{ResponseBodyAdvice}
        logger.info("-----ExampleHandlerInterceptor 开始执后处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //在整个请求完成之后
        logger.info("-----ExampleHandlerInterceptor 执行完毕");
    }
}
