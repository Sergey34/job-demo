package com.es.job.demo.configuration.es.properties

import com.es.job.demo.service.HostAndPort
import org.elasticsearch.common.transport.TransportAddress
import java.net.InetSocketAddress

class ElasticsearchProperties {
    lateinit var protocol: String
    lateinit var clusterName: String
    lateinit var clusterNodes: String

    fun getHttpHosts(): Sequence<TransportAddress> {
        return clusterNodes.split(", ?".toRegex())
            .asSequence()
            .map { HostAndPort.fromString(it) }
            .map { node -> InetSocketAddress(node.getHost(), node.getPort()) }
            .map { TransportAddress(it) }


    }
}