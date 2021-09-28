package com.rumenz.proxy.demo;

import com.rumenz.proxy.demo.config.SpringConfig;
import com.rumenz.proxy.demo.proxy.UserInvoke;
import com.rumenz.proxy.demo.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.lang.reflect.Proxy;

/**
 * @className: Test123
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/28
 **/
public class Test123 {
    public static void main(String[] args) {
        ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        //  UserServiceImpl 在容器中默认的名称是 userServiceImpl
        UserService userService = (UserService) app.getBean("userServiceImpl");
        UserInvoke userInvoke = new UserInvoke(userService);
        UserService us= (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),userInvoke);
        us.say();
    }
}
