package com.rumenz.rabbitmq.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: DirrectRabbitmqConfig
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/10
 **/

@Configuration
public class DirectRabbitmqConfig {

    //创建队列
    @Bean
    public Queue rumenzDirect(){
        return new Queue("rumenzDirect",true);
    }

    @Bean
    public Queue rumenzDirect1(){
        return new Queue("rumenzDirect1",true);
    }



    @Bean
    public DirectExchange rumenzDirectExchange(){
        return new DirectExchange("rumenzDirectExchange");
    }



    @Bean
    Binding bindDirect(){
        return BindingBuilder.bind(rumenzDirect()).to(rumenzDirectExchange()).with("testDirectRouting");
    }

    @Bean
    Binding bindDirect2(){
        return BindingBuilder.bind(rumenzDirect1()).to(rumenzDirectExchange()).with("testDirectRouting");
    }



}
