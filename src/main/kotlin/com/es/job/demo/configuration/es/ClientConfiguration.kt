package com.es.job.demo.configuration.es

import com.es.job.demo.configuration.es.properties.ElasticsearchProperties
import org.elasticsearch.client.Client
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.transport.client.PreBuiltTransportClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfiguration  {
    @Bean
    @ConfigurationProperties(prefix = "spring.data.elasticsearch")
    fun elasticsearchProperties(): ElasticsearchProperties {
        return ElasticsearchProperties()
    }

    @Bean
    fun elasticsearchClient(): Client {
        val properties = elasticsearchProperties()
        val settings = Settings.builder().put("cluster.name", properties.clusterName).build()
        val client = PreBuiltTransportClient(settings)
        properties.getHttpHosts().forEach { client.addTransportAddress(it) }
        return client
    }
}