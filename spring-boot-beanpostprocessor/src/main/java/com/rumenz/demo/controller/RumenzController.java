package com.rumenz.demo.controller;


import com.rumenz.demo.config.Routeing;
import com.rumenz.demo.service.RumenzHelloService;
import com.rumenz.demo.verviceImpl.RumenzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/8/30
 **/
@RestController
public class RumenzController {


    @Routeing("RumenzHello2ServiceImpl")
    RumenzHelloService rumenzHelloService;

    @GetMapping("/index")
    public String hello(){
      return rumenzHelloService.say();
    }
}
