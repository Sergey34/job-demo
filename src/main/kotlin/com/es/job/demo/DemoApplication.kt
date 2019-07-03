package com.es.job.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ImportResource

@ImportResource("file:config/job_beans.xml")
@SpringBootApplication
@EnableConfigurationProperties
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
