package com.david.rpcproxy.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2019/11/21 3:30 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:自定义 注解
 * @since 1.0
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoRpcClient {

    String name() default "";

    /**
     * Whether to mark the feign proxy as a primary bean. Defaults to true.
     */
    boolean primary() default true;

}
