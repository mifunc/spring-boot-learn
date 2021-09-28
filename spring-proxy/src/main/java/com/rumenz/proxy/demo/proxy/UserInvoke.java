package com.rumenz.proxy.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className: UserInvoke
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/23
 **/
public class UserInvoke implements InvocationHandler {
    private Object target;

    public UserInvoke(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = method.invoke(target, args);
        String name = method.getName();
        if("say".equals(name)){
            System.out.println("记录日志");
        }

        return obj;
    }
}
