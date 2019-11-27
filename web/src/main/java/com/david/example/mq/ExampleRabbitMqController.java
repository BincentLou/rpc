package com.david.example.mq;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2019/9/10 10:42 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:mq发送控制器
 * @since 1.0
 **/
@RestController
public class ExampleRabbitMqController {


//    @Autowired
//    private RabbitMqSender rabbitMqSender;
//
//    /**
//     * 广播模式 只要发送到固定的转发器
//     * @param message
//     * @return
//     */
//    @RequestMapping("/rabbitmq/fanout/{message}")
//    public String rabbitmq(@PathVariable String message){
//        RabbitMqBaseMessage msgObj = new RabbitMqBaseMessage();
//        msgObj.setData(message);
//        rabbitMqSender.sendFanout(msgObj);
//        return JSON.toJSONString(msgObj);
//    }
//
//    /**
//     * routing 模式 需要转发器和路由关键字转发到 消息队列
//     * @param message
//     * @return
//     */
//    @RequestMapping("/rabbitmq/redirect/error/{message}")
//    public String sendRedirectErrorMessage(@PathVariable String message){
//        RabbitMqBaseMessage<String> msgObj = new RabbitMqBaseMessage<>(message);
//        rabbitMqSender.sendDirectError(msgObj);
//        return JSON.toJSONString(msgObj);
//    }
//
//    @RequestMapping("/rabbitmq/redirect/info/{message}")
//    public String sendRedirectInfoMessage(@PathVariable String message){
//        RabbitMqBaseMessage<String> msgObj = new RabbitMqBaseMessage<>(message);
//        rabbitMqSender.sendDirectInfo(msgObj);
//        return JSON.toJSONString(msgObj);
//    }
//
//    /**
//     * 主题模式，需要转发器和主题一起合作
//     * @param topic
//     * @param message
//     * @return
//     */
//    @RequestMapping("/rabbitmq/topic/{topic}/{message}")
//    public String sendTopicMessage(@PathVariable String topic,@PathVariable String message){
//        RabbitMqBaseMessage<String> msgObj = new RabbitMqBaseMessage<>(message);
//        rabbitMqSender.sendTopic(topic,msgObj);
//        return JSON.toJSONString(msgObj);
//    }
}
