package com.david.example.springMvc.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2019/8/29 11:21 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:filter 样例
 * @since 1.0
 **/
@Order(5)
public class ExampleFilter extends OncePerRequestFilter {

    private  Logger logger = LoggerFactory.getLogger(ExampleFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("-----调用exampleFilter开始，打印访问参数");
        printRequestParamter(request);
        filterChain.doFilter(request, response);
    }

    private void printRequestParamter(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Map<String, String[]> paramMap = request.getParameterMap();
        sb.append("请求uri：").append(request.getRequestURI());
        paramMap.entrySet().forEach(item->sb.append(item.getKey()).append(":").append(item.getValue()));
        logger.info(sb.toString());

        try {
            ServletInputStream in = request.getInputStream();
            String para = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            if(!StringUtils.isEmpty(para)){
                logger.info("请求参数："+para);

            }
        } catch (IOException e) {
            logger.error("获取request的输入流失败");
        }
    }
}
