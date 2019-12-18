package com.david.rpcproxy.xxl;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Service;

/**
 * @version $Id: null.java, v 1.0 2019/12/17 1:45 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Service
@JobHandler(value = "demoJob")
public class DemoJob extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("----------------------------xxxxxxxxxlllllllll------------------------------");
        System.out.println("----------------------------xxxxxxxxxlllllllll------------------------------");
        System.out.println("----------------------------xxxxxxxxxlllllllll------------------------------");
        System.out.println("----------------------------xxxxxxxxxlllllllll------------------------------");
        System.out.println("----------------------------xxxxxxxxxlllllllll------------------------------");
        return ReturnT.SUCCESS;
    }
}
