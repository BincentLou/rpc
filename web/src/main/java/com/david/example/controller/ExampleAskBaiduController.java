package com.david.example.controller;

import com.david.rpcproxy.anno.DemoRpcBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version $Id: null.java, v 1.0 2019/11/21 4:40 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class ExampleAskBaiduController {
    @Resource
    private DemoRpcBean demoRpcBean;

    @RequestMapping("/askbaidu")
    public String askBaidu(String wd){
//       return demoRpcBean.askBaidu(wd);
        return null;
    }

}
