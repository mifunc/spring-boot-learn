package com.rumenz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/5
 **/

@RestController
@RequestMapping("/index")
public class RumenzController {

    private Map<String, ScheduledFuture<?>> map=new HashMap<>();

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @PostMapping("/addTask")
    public String addTask(@RequestParam("name") String name,@RequestParam("cron") String cron){
        ScheduledFuture<?> scheduledFuture = map.get(name);
        if(scheduledFuture!=null) return "任务已经存在";
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(new TaskRunable(name), new CronTrigger(cron));
        map.put(name,schedule);
        return "任务创建成功";
    }

    @GetMapping("/stopTask")
    public String stopTask(@RequestParam("name") String name){
        ScheduledFuture<?> scheduledFuture = map.get(name);
        if(scheduledFuture==null) return "任务不存在";
        scheduledFuture.cancel(true);
        map.remove(name);
        return "任务删除成功";
    }

    @GetMapping("/listTask")
    public String listTask(){
        String collect = map.keySet().stream().collect(Collectors.joining(","));
        return collect;
    }
    @PostMapping("/changeTask")
    public String changeTask(@RequestParam("name") String name,@RequestParam("cron") String cron){
        ScheduledFuture<?> scheduledFuture = map.get(name);
        if(scheduledFuture!=null) {
            scheduledFuture.cancel(true);
            map.remove(name);
        }

        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(new TaskRunable(name), new CronTrigger(cron));
        map.put(name,schedule);
        return "任务创建成功";


    }



}

class TaskRunable implements Runnable{

    private String name;

    public TaskRunable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(">>>>>>>>>"+this.name+"任务开始执行");

    }
}

