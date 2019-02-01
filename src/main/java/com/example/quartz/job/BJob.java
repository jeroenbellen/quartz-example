package com.example.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class BJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Job b says hi !");
    }
}
