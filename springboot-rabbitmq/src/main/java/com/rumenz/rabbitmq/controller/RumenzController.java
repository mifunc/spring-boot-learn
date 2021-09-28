package com.rumenz.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: Rumenz
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/10
 **/

@RestController
public class RumenzController {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send(){
        String res="hello";
        rabbitTemplate.convertAndSend("rumenzDirectExchange", "testDirectRouting",res.getBytes());
        return "";
    }
    @GetMapping("/send1")
    public String send1(){
        String res="hello1";
        rabbitTemplate.convertAndSend("rumenzDirectExchange", "testDirectRouting",res.getBytes());
        return "";
    }

    @GetMapping("/send3")
    public String send3(){
        String res="fanout";
        rabbitTemplate.convertAndSend("fanoutExchange",null,res.getBytes());
        return "ok";
    }

    @GetMapping("/send4")
    public String send4(@RequestParam("r") String r){
        String res="topic";
        rabbitTemplate.convertAndSend("topicExchange",r,res.getBytes());
        return "ok";
    }
}
