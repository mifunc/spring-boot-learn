package com.rumenz.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @className: DirectRecever
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/10
 **/

@Component
public class DirectRecever {

    @RabbitHandler
    @RabbitListener(queues = "rumenzDirect")
    public void getMessage(String msg){
        System.out.println("收到消息getMessage:"+msg.toString());
    }
    @RabbitHandler
    @RabbitListener(queues = "rumenzDirect1")
    public void getMessage1(String msg){
        System.out.println("收到消息getMessage1:"+msg.toString());
    }
}
