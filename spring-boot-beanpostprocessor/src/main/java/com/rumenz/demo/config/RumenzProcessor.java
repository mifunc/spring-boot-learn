package com.rumenz.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import sun.java2d.opengl.OGLSurfaceDataProxy;

import java.lang.reflect.Field;
import java.util.IllegalFormatException;
import java.util.Map;

/**
 * @className: RumenzProcessor
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/8/30
 **/
@Component
public class RumenzProcessor implements BeanPostProcessor {


    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("===================>>>>>>>>>>");
        Class<?> aClass = bean.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field:declaredFields){
            boolean annotationPresent = field.isAnnotationPresent(Routeing.class);
            if(annotationPresent){
                if(!field.getType().isInterface()){
                    throw new BeanCreationException("注解只能使用在接口上");
                }
                try {
                    this.handleRoutingInjected(field, bean, field.getType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;

    }

    private void handleRoutingInjected(Field field, Object bean, Class type) throws IllegalAccessException {
        Map<String, Object> beansOfType = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if(beansOfType.size()==1){
            field.set(bean,beansOfType.values().iterator().next());
        } else{
            String value = field.getAnnotation(Routeing.class).value();
            Object proxy = RoutingBeanProxyFactory.createProxy(value, type, beansOfType);
            field.set(bean, proxy);

        }

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
