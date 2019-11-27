package com.david.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 3:42 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:rabbit mq fanout 模式发送消息
 * @since 1.0
 **/
@Component
public class RabbitMqSender {

//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    public void sendFanout(RabbitMqBaseMessage message){
//        this.amqpTemplate.convertAndSend(ExampleRabbitMqConfig.FANOUT_EXCHANGE_B,"",message);
//    }
//
//    public void sendDirectError(RabbitMqBaseMessage<String> msgObj) {
//        amqpTemplate.convertAndSend(ExampleRabbitMqConfig.DIRECT_EXCHANGE,ExampleRabbitMqConfig.DIRECT_ROUNT_ERROR,msgObj);
//    }
//
//    public void sendDirectInfo(RabbitMqBaseMessage<String> msgObj) {
//        amqpTemplate.convertAndSend(ExampleRabbitMqConfig.DIRECT_EXCHANGE,ExampleRabbitMqConfig.DIRECT_ROUNT_INFO,msgObj);
//    }
//
//    public void sendTopic(String topic, RabbitMqBaseMessage<String> msgObj) {
//        amqpTemplate.convertAndSend(ExampleRabbitMqConfig.TOPIC_EXCHANGE_A,topic,msgObj);
//    }
}
