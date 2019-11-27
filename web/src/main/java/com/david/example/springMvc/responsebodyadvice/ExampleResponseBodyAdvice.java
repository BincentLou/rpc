package com.david.example.springMvc.responsebodyadvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @version $Id: null.java, v 1.0 2019/8/27 10:56 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:可以在adapter处理ResponseBody完成后，写出之前处理特殊逻辑
 * @since 1.0
 **/
public class ExampleResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}
