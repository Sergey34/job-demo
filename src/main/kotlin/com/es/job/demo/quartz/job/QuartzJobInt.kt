package com.es.job.demo.quartz.job

import org.quartz.JobExecutionContext

interface QuartzJobInt {
    fun executeInternal(context: JobExecutionContext)
    fun loadData(): Any
    fun writeData(data: Any)
    fun getTitle(): String
    fun getTrigger(): String
    fun getClassJob(): Class<JobBean>
    fun getOrder(): Int
}
