package com.david.example.springMvc.handlerexceptionresolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version $Id: null.java, v 1.0 2019/8/27 11:03 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:解决 异常的处理器，会被dispatcherServlet调用，链式处理模式，有默认的异常处理器，需要配置顺序.
 * 注意：：：跟@ControllerAdvice注解是冲突的，返回null的话，容器处理，返回空model的话异常中断
 * @since 1.0
 **/
@Order(1)
@Component
public class ExampleHandlerExceptionResolver implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(ExampleHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //如果ModelAndView 是empty 说明处理完成，如果返回的是null，传递个下个处理器处理，如果整个chain都没有处理完成，上升到Servlet container
        logger.info("hanlder"+handler.getClass().toString()+"出错了，错误异常类型是"+ex.getClass().toString());
        try {
            response.getWriter().write("出错了，校验异常");
        } catch (IOException e) {
            logger.error(e.getMessage());

        }
        return null;
    }
}
