package com.david.example.springMvc.mutilpartresovler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * @version $Id: null.java, v 1.0 2019/8/28 9:44 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:配置一个standdardServletMutilPartResolver 处理 servlet 3 的文件上传
 * @since 1.0
 **/
@Configuration
public class MutilPartResolverConfig {


    @Bean
    public StandardServletMultipartResolver mutilpartResolver(){
        return new StandardServletMultipartResolver();
    }
}
