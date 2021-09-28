package com.rumenz.demo.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @className: PoolConfig
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/5
 **/

@Configuration
public class PoolConfig {

    //@Bean
    public TaskScheduler taskScheduled(){
        ThreadPoolTaskScheduler taskScheduled=new ThreadPoolTaskScheduler();
        taskScheduled.initialize();
        taskScheduled.setPoolSize(5);
        return taskScheduled;

    }
    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskScheduled=new ThreadPoolTaskExecutor();
        taskScheduled.initialize();
        taskScheduled.setCorePoolSize(10);
        return taskScheduled;

    }
}
