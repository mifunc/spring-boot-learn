package com.rumenz.demo.config;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @className: Routeing
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/8/30
 **/

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Routeing {
    String value() default  "RumenzHello1ServiceImpl";
}
