package com.david.example.mq;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 4:25 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:rabbit redirect receiver
 * @since 1.0
 **/
@Component
public class RedirectReceiver {

    private Logger logger = LoggerFactory.getLogger(RedirectReceiver.class);
//
//    @RabbitListener(queues = ExampleRabbitMqConfig.DIRECT_QUEUE_E)
//    public void redirectError(RabbitMqBaseMessage baseMessage){
//        logger.info("{} 队列收到消息：{}",ExampleRabbitMqConfig.DIRECT_QUEUE_E, JSON.toJSON(baseMessage));
//    }
//
//    @RabbitListener(queues = ExampleRabbitMqConfig.DIRECT_QUEUE_F)
//    public void redirectInfo(RabbitMqBaseMessage baseMessage){
//        logger.info("{} 队列收到消息：{}",ExampleRabbitMqConfig.DIRECT_QUEUE_F, JSON.toJSON(baseMessage));
//    }

}
