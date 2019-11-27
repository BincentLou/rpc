package com.david.example.controller;

import com.alibaba.fastjson.JSON;
import com.david.example.DTO.OtherQuest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/8/30 9:38 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:跨域请求的示例
 * @since 1.0
 **/
@CrossOrigin
@RestController
public class ExampleCrosController {

    private Logger logger = LoggerFactory.getLogger(ExampleCrosController.class);

    @CrossOrigin
    @RequestMapping("/getaccount")
    public String getAccount(@RequestBody OtherQuest quest){
        logger.info(JSON.toJSONString(quest));
        return "跨域请求成功";
    }
}
