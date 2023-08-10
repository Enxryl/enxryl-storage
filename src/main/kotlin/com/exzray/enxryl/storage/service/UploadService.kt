package com.exzray.enxryl.storage.service

import org.springframework.http.ResponseEntity
import org.springframework.http.codec.multipart.FilePart
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UploadService {
    fun uploadFiles(files: Flux<FilePart>): Mono<ResponseEntity<Any>>
}