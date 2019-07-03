package com.es.job.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ImportResource
import java.io.File

@ImportResource("file:config/job_beans.xml")
@SpringBootApplication
@EnableConfigurationProperties
class DemoApplication


fun main(args: Array<String>) {
    val prefix = """
    |<?xml version="1.0" encoding="UTF-8"?>
    |<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    |       xmlns:lang="http://www.springframework.org/schema/lang" xmlns="http://www.springframework.org/schema/beans"
    |       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang.xsd">
    |    <beans>
    |    
""".trimMargin()
    val postfix = """
    |
    |    </beans>
    |</beans>
""".trimMargin()

    val file = File("./scripts/groovy/jobs")
    val xmlGroovyBeans = file.listFiles()
        .asSequence()
        .filter { it.isFile }
        .map {
            """
                |    <lang:groovy id="${it.nameWithoutExtension}"
                |                     refresh-check-delay="5000"
                |                     script-source="file:${it.path}">
                |        </lang:groovy>
                """.trimMargin()
        }
        .joinToString(separator = "\n", prefix = prefix, postfix = postfix) { it }
    File("./config/job_beans.xml").writeText(xmlGroovyBeans)




    runApplication<DemoApplication>(*args)
}