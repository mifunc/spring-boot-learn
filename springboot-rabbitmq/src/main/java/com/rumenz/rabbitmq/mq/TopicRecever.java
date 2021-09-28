package com.rumenz.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: TopicRecever
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/12
 **/

@Component
public class TopicRecever {


    @RabbitListener(queues = "topicOne")
    @RabbitHandler
    public void msgOne(String msg){
        System.out.println("msgOne get msg:"+msg);
    }
    @RabbitListener(queues = "topicTow")
    @RabbitHandler
    public void msgTow(String msg){
        System.out.println("msgTow get msg:"+msg);
    }

}
