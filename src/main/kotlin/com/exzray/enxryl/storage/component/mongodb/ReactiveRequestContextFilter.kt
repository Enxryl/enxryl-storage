package com.exzray.enxryl.storage.component.mongodb

import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class ReactiveRequestContextFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request
        return chain.filter(exchange).contextWrite { it.put(ReactiveRequestContextHolder.REQUEST_KEY, request) }
    }
}