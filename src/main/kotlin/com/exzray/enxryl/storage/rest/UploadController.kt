package com.exzray.enxryl.storage.rest

import com.exzray.enxryl.storage.service.UploadService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/upload")
class UploadController(private val uploadService: UploadService) {
    private val logger = LoggerFactory.getLogger(UploadController::class.java)

    @PostMapping("")
    fun uploadFiles(
        @RequestPart("files") files: Flux<FilePart>,
        exchange: ServerWebExchange
    ): Mono<ResponseEntity<Any>> {
        logger.info("received -> username: {}", exchange.request.headers.getFirst("X-Username"))

        return uploadService.uploadFiles(files)
    }
}