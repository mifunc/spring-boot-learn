package com.rumenz.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: FanoutRabbitmqConfig
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/11
 **/
@Configuration
public class FanoutRabbitmqConfig {

    @Bean
    public Queue queueOne(){
        return new Queue("queueOne",true);
    }

    @Bean
    public Queue queueTow(){
        return new Queue("queueTow",true);
    }

    @Bean
    public Queue queueThree(){
        return new Queue("queueThree",true);
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }


    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());

    }
    @Bean
    Binding bindingTow(){
        return BindingBuilder.bind(queueTow()).to(fanoutExchange());

    }
    @Bean
    Binding bindingThree(){
        return BindingBuilder.bind(queueThree()).to(fanoutExchange());

    }
}
