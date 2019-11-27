package com.david.example.transaction;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 7:52 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class ExampleTransaction {

    @Transactional(rollbackFor = Exception.class)
    public void trans(String msg){
        System.out.println(this.getClass().toString());
    }
}
