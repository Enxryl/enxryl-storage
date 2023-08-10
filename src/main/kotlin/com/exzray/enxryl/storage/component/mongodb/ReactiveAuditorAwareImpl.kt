package com.exzray.enxryl.storage.component.mongodb

import org.springframework.data.domain.ReactiveAuditorAware
import reactor.core.publisher.Mono

class ReactiveAuditorAwareImpl : ReactiveAuditorAware<String> {
    override fun getCurrentAuditor(): Mono<String> {
        return ReactiveRequestContextHolder.getRequest()
            .mapNotNull { it.headers.getFirst("X-Username") }
    }
}