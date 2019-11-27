package com.david.example;

import com.david.example.mq.RabbitMqSender;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version $Id: null.java, v 1.0 2019/9/17 5:20 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 基础的测试类
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners(MockitoTestExecutionListener.class)
public class ExampleBaseTest {
//
//    private static Logger logger = LoggerFactory.getLogger(ExampleBaseTest.class);
//
//    @MockBean
//    protected StringRedisTemplate stringRedisTemplate;
//
//    @MockBean
//    protected RabbitMqSender rabbitMqSender;
//
//    @Before
//    public void testBefore(){
//        logger.info("开始测试");
//
//    }
//    @After
//    public void testAfter(){
//        logger.info("测试结束");
//    }

}
