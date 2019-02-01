package com.example.quartz.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(AJob.class).withIdentity("sampleJobA")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {

        return TriggerBuilder.newTrigger().forJob(jobADetails)

                .withIdentity("sampleTriggerA")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * ? * * *"))
                .build();
    }


    @Bean
    public JobDetail jobBDetails() {
        return JobBuilder.newJob(BJob.class).withIdentity("sampleJobB")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobBTrigger(JobDetail jobBDetails) {

        return TriggerBuilder.newTrigger().forJob(jobBDetails)

                .withIdentity("sampleTriggerB")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * * *"))
                .build();
    }


}
