package com.rumenz.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @className: RumenzTask
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/4
 **/
//@Component
public class RumenzTask {

    private String format(String str){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        return format;
    }

    @Scheduled(fixedRate = 1000)
    public void run1(){

        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(3000);
            System.out.println("=====>run1"+name+">>>"+format("run1"));
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    @Scheduled(fixedRate = 1000)
    public void run2(){
        String name = Thread.currentThread().getName();

        try {
            Thread.sleep(3000);
            System.out.println("=====>run2"+name+">>>"+format("run2"));
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
