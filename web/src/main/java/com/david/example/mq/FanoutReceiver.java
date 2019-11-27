package com.david.example.mq;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 4:00 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:rabbit fanout 类型接收器
 * @since 1.0
 **/
@Component
public class FanoutReceiver {

//    private Logger logger = LoggerFactory.getLogger(FanoutReceiver.class);
//
//    /**
//     * 消息消费的方法不能有返回值
//     * @param baseMessage
//     */
//    @RabbitListener(queues = ExampleRabbitMqConfig.FANOUT_QUEUE_C)
//    public void receiveTopicC(RabbitMqBaseMessage baseMessage){
//        logger.info("{} 消息队列接到消息：{}",ExampleRabbitMqConfig.FANOUT_QUEUE_C, JSON.toJSON(baseMessage));
//    }
//
//    @RabbitListener(queues = ExampleRabbitMqConfig.FANOUT_QUEUE_D)
//    public void receiveTopicD(RabbitMqBaseMessage baseMessage){
//        logger.info("{} 消息队列接到消息：{}",ExampleRabbitMqConfig.FANOUT_QUEUE_D, JSON.toJSON(baseMessage));
//    }
}
