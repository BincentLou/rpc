package com.david.example.controller;

import com.david.example.configproperty.ExampleYamlConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version $Id: null.java, v 1.0 2019/8/24 11:57 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class ExampleYamlConfigController {

    @Resource
    private ExampleYamlConfig exampleYamlConfig;

    @RequestMapping("/yamlconfig")
    public String yamlconfig(){
        StringBuilder s = new StringBuilder();
        exampleYamlConfig.getServers().forEach(item->s.append(item));
        return s.toString();
    }

    @RequestMapping("/security")
    public String security(){
        StringBuilder s = new StringBuilder();
        exampleYamlConfig.getSecurity().getRoles().forEach(item->s.append(item).append("/"));
        return s.toString();
    }
}
