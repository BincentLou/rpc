package com.david.example.springMvc.mutilpartresovler;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @version $Id: null.java, v 1.0 2019/8/28 10:32 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:common.apache的文件上传配置
 * @since 1.0
 **/
@Component(value = "mutilpartResolver")
public class ExampleCommonMutilpartResolver extends CommonsMultipartResolver {
}
