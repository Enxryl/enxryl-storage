package com.exzray.enxryl.storage.component.mongodb

import org.springframework.http.server.reactive.ServerHttpRequest
import reactor.core.publisher.Mono

class ReactiveRequestContextHolder {
    companion object {
        val REQUEST_KEY: Class<ServerHttpRequest> = ServerHttpRequest::class.java

        fun getRequest(): Mono<ServerHttpRequest> {
            return Mono.deferContextual { Mono.just(it.get(REQUEST_KEY)) }
        }
    }
}