package com.educacionit;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobScheduler {

    public static void main(String[] args) throws Exception {

        try {

            // specify the job' s details..
            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("testJob").usingJobData("jobSays", "Hello World!").usingJobData("myFloatValue", 3.141f)
                    .build();

            // specify the running period of the job
            // CronTrigger the job to run on the every 20 seconds
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("crontrigger","crontriggergroup1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("10 * * * * ?"))
                    .build();

            //schedule the job
            SchedulerFactory schFactory = new StdSchedulerFactory();
            Scheduler sch = schFactory.getScheduler();
            sch.start();
            sch.scheduleJob(job, cronTrigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
