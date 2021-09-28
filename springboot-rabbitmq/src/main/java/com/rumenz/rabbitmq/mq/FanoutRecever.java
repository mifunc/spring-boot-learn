package com.rumenz.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: FanoutRecever
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/11
 **/
@Component
public class FanoutRecever {

    @RabbitHandler
    @RabbitListener(queues = "queueOne")
    public void msg1(String msg){
        System.out.println("queueOne get msg"+msg);
    }
    @RabbitHandler
    @RabbitListener(queues = "queueTow")
    public void msg2(String msg){
        System.out.println("queueTow get msg"+msg);
    }
    @RabbitHandler
    @RabbitListener(queues = "queueThree")
    public void msg3(String msg){
        System.out.println("queueThree get msg"+msg);
    }
}
