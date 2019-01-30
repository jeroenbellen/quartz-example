package com.example.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Hi there ! " + new Date());
    }
}
