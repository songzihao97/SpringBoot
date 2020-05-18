package com.szh.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * 定时任务
     * on the second, minute, hour, day of month, month, and day of week.
     * <p>For example, {@code "0 * * * * MON-FRI"} means once per minute on weekdays
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello(){
        System.out.println("hello...");
    }
}
