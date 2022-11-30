package com.sinby.demo.config;

import com.sinby.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author ：sinby
 * @Date :2022/05/18 16:17
 * @Version 1.0
 */
@EnableScheduling
@Configuration
@ConditionalOnProperty(name = "enabled.scheduing.flag", havingValue = "true")
public class SchedulingConfig {

    @Autowired
    TaskService taskService;

    //三十分钟执行一次  fixedRate = 1000*60*30  三小时执行一次 cron = "${enabled.scheduing.cron}"
    @Scheduled(cron = "${enabled.scheduing.cron}")
    public void runTaskOfRedis(){
        taskService.purchaseTask();
    }
}
