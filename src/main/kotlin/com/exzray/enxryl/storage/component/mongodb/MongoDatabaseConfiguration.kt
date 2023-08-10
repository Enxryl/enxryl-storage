package com.exzray.enxryl.storage.component.mongodb

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.ReactiveAuditorAware
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories("com.exzray.enxryl.storage.domain")
@EnableReactiveMongoAuditing
class MongoDatabaseConfiguration {
    @Bean
    fun reactiveAuditorAware(): ReactiveAuditorAware<String> {
        return ReactiveAuditorAwareImpl()
    }
}