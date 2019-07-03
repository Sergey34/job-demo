package com.es.job.demo.quartz.job

import org.quartz.JobExecutionContext
import org.quartz.Scheduler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.quartz.QuartzJobBean

abstract class JobBean : QuartzJobBean(), QuartzJobInt, Comparable<JobBean> {
    @Autowired
    @Suppress("SpringJavaAutowiredMembersInspection")
    private lateinit var scheduler: Scheduler

    override fun executeInternal(context: JobExecutionContext) {
        scheduler.pauseJob(context.jobDetail.key)
        try {
            val data = loadData()
            writeData(data)
        } finally {
            scheduler.resumeJob(context.jobDetail.key)
        }
    }

    override fun getClassJob(): Class<JobBean> {
        return this.javaClass
    }

    override fun compareTo(other: JobBean): Int {
        return this.getOrder().compareTo(other.getOrder())
    }
}