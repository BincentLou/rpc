package com.david.example.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version $Id: null.java, v 1.0 2019/9/11 2:46 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:rabbit mq的配置类
 * @since 1.0
 **/
@Configuration
public class ExampleRabbitMqConfig {

    private Logger logger = LoggerFactory.getLogger(ExampleRabbitMqConfig.class);

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String userName;

    @Value("${spring.rabbitmq.password}")
    private String password;


    //    topic 模式 主题模式
    public static final String TOPIC_QUEUE_A = "topic-queue-a";
    public static final String TOPIC_QUEUE_B = "topic-queue-b";
    public static final String TOPIC_EXCHANGE_A = "topic-exchange-a";

    //fanout模式 广播
    public static final String FANOUT_QUEUE_C = "fanout_queue-c";
    public static final String FANOUT_QUEUE_D = "fanout_queue-d";
    public static final String FANOUT_EXCHANGE_B = "fanout-exchange-B";

    // redirect  routing 模式
    public static final String DIRECT_QUEUE_E = "redirect-queue-e";
    public static final String DIRECT_QUEUE_F = "redirect-queue-f";
    public static final String DIRECT_EXCHANGE = "redirect-exchange-c";
    public static final String DIRECT_ROUNT_ERROR = "direct-error";
    public static final String DIRECT_ROUNT_INFO = "direct-info";

//
////topic 模式
//    @Bean
//    public Queue topicQueueA(){
//        return new Queue(TOPIC_QUEUE_A);
//    }
//
//    @Bean
//    public Queue topicQueueB(){
//        return new Queue(TOPIC_QUEUE_B);
//    }
//
//    @Bean
//    public TopicExchange topicExchangeA(){
//        return new TopicExchange(TOPIC_EXCHANGE_A);
//    }
//
//    @Bean
//    public Binding topicBindingA(){
//        //监听 topicC前又一个单词的消息
//        return BindingBuilder.bind(topicQueueA()).to(topicExchangeA()).with("*.topicC");
//    }
//    @Bean
//    public Binding topicBindingB(){
//        // 监听 topicC前有多个单词的消息
//        return BindingBuilder.bind(topicQueueB()).to(topicExchangeA()).with("#.topicC");
//    }
//
////    fanout 模式 广播，没有routing key 没有topic 只要订阅到转发器就会收到消息
//    @Bean
//    public Queue fanoutQueueA(){
//        return new Queue(FANOUT_QUEUE_C);
//    }
//    @Bean
//    public Queue fanoutQueueB(){
//        return new Queue(FANOUT_QUEUE_D);
//    }
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange(FANOUT_EXCHANGE_B);
//    }
//
//    @Bean
//    public Binding fanoutBindingA(){
//        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
//    }
//    @Bean
//    public Binding fanoutBindingB(){
//        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
//    }
//
////    redirect 模式 需要转发器和routing key一起合作
//    @Bean
//    public Queue redirectQueueE(){
//        return new Queue(DIRECT_QUEUE_E);
//    }
//    @Bean
//    public Queue redirectQueueF(){
//        return new Queue(DIRECT_QUEUE_F);
//    }
//
//    @Bean
//    public DirectExchange redirectExchange(){
//        return new DirectExchange(DIRECT_EXCHANGE);
//    }
//
//    @Bean
//    public Binding directBingdingE(){
//        return BindingBuilder.bind(redirectQueueE()).to(redirectExchange()).with(DIRECT_ROUNT_ERROR);
//    }
//
//    @Bean
//    public Binding directBingdingF(){
//        return BindingBuilder.bind(redirectQueueF()).to(redirectExchange()).with(DIRECT_ROUNT_INFO);
//    }

}
