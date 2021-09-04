package com.rumenz.demo.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @className: RoutingBeanProxyFactory
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/8/30
 **/
public class RoutingBeanProxyFactory {

    private final static String DEFAULT_BEAN_NAME = "RumenzHelloServiceImpl";

    public static Object createProxy(String name, Class type, Map<String, Object> beans) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(type);

        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                Object o = beans.get(name);
                if (o == null) {
                    o = beans.get(DEFAULT_BEAN_NAME);
                }
                System.out.println(methodInvocation.getMethod().toString());
                System.out.println(o.toString());
                return methodInvocation.getMethod().invoke(o, methodInvocation.getArguments());

            }
        });

        return proxyFactory.getProxy();
    }

}