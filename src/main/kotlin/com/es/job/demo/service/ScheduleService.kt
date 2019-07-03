package com.es.job.demo.service

import com.es.job.demo.quartz.job.JobBean
import com.es.job.demo.quartz.job.QuartzJobInt
import org.quartz.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
class ScheduleService @Autowired constructor(
    val scheduler: Scheduler,
    val jobs: List<QuartzJobInt>
) {

    @PostConstruct
    fun init() {

        jobs.forEach {
            val title = it.getTitle()
            scheduler.scheduleJob(
                buildJobDetail(title, it.getClassJob()),
                buildTrigger(title, it.getTrigger())
            )
        }
    }

    private fun buildTrigger(title: String, trigger: String): CronTrigger {
        return TriggerBuilder
            .newTrigger()
            .withIdentity(title, "demo")
            .withSchedule(
                CronScheduleBuilder.cronSchedule(trigger)
            )
            .build()
    }

    private fun buildJobDetail(title: String, clazz: Class<JobBean>): JobDetail {
        val jobDataMap = JobDataMap()
        return JobBuilder.newJob(clazz)
            .withIdentity(title, "demo")
            .usingJobData(jobDataMap)
            .storeDurably()
            .build()
    }
}