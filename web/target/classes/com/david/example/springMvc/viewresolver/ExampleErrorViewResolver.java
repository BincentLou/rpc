package com.david.example.springMvc.viewresolver;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2019/9/3 7:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:错误视图解析器，可以根据错误码映射不同的页面比如 404 500 页面
 * @since 1.0
 **/
public class ExampleErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        return null;
    }
}
