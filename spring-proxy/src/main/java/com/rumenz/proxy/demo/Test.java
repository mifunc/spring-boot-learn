package com.rumenz.proxy.demo;

import com.rumenz.proxy.demo.proxy.UserInvoke;
import com.rumenz.proxy.demo.service.UserService;
import com.rumenz.proxy.demo.serviceImpl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @className: Test
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/23
 **/
public class Test {

    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        UserInvoke userInvoke = new UserInvoke(userService);
        UserService us= (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),userInvoke);
        us.say();
    }
}
