# Spring Boot: How to run quartz in a cluster?

Add the following application properties:

```
spring.quartz.job-store-type=jdbc
spring.quartz.properties.org.quartz.jobStore.isClustered=true
spring.quartz.properties.org.quartz.scheduler.instanceId=AUTO
```

Start the application and verify in the logs that the correct JobStore is used:

```
2019-02-01 13:39:17.600  INFO 11310 --- [           main] org.quartz.core.QuartzScheduler          : Scheduler meta-data: Quartz Scheduler (v2.3.0) 'quartzScheduler' with instanceId 'Jeroens-MacBook-Pro.local1549024757590'
  Scheduler class: 'org.quartz.core.QuartzScheduler' - running locally.
  NOT STARTED.
  Currently in standby mode.
  Number of jobs executed: 0
  Using thread pool 'org.quartz.simpl.SimpleThreadPool' - with 10 threads.
  Using job-store 'org.springframework.scheduling.quartz.LocalDataSourceJobStore' - which supports persistence. and is clustered.
```

If multiple applications are using the same database, - which is a bad practice -
make sure to split up the quartz tables by using a prefix. **Don't share the same quartz tables for multiple applications!**

```
spring.quartz.properties.org.quartz.jobStore.tablePrefix=MYAPP_

