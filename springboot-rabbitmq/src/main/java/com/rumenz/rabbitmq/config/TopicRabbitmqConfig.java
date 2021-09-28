package com.rumenz.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: TopicRabbitmqConfig
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/12
 **/

@Configuration
public class TopicRabbitmqConfig {
    @Bean
    public Queue topicOne(){
        return new Queue("topicOne");
    }

    @Bean
    public Queue topicTow(){
        return new Queue("topicTow");
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingTopicOne(){
        return BindingBuilder.bind(topicOne()).to(topicExchange()).with("rumenz.one");
    }
    @Bean
    public Binding bindingTopicTow(){
        return BindingBuilder.bind(topicTow()).to(topicExchange()).with("rumenz.#");
    }
}

