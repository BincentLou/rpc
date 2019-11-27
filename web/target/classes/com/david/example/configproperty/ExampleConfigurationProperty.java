package com.david.example.configproperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @version $Id: null.java, v 1.0 2019/8/23 3:49 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:$引入配置文件示例
 * @since 1.0
 **/
//@ImportResource(value = "./example.properties") 只能引入xml
@Configuration
@PropertySource(value = "classpath:/example.properties") //一定要跟@Configuration一起使用，不能加载yaml文件
public class ExampleConfigurationProperty {

}
