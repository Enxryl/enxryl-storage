package com.exzray.enxryl.storage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class EnxrylStorageApplication

fun main(args: Array<String>) {
    runApplication<EnxrylStorageApplication>(*args)
}