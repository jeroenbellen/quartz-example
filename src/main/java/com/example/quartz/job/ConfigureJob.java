package com.example.quartz.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Bean
    public JobDetail sampleJobDetail() {
        return JobBuilder.newJob(AJob.class).withIdentity("sampleJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger() {

        return TriggerBuilder.newTrigger().forJob(sampleJobDetail())

                .withIdentity("sampleTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * ? * * *"))
                .build();
    }

}
