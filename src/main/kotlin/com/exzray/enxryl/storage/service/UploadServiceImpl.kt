package com.exzray.enxryl.storage.service

import com.exzray.enxryl.storage.domain.FileDocument
import com.exzray.enxryl.storage.domain.FileRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UploadServiceImpl(private val fileRepository: FileRepository) : UploadService {
    private val logger: Logger = LoggerFactory.getLogger(UploadService::class.java)

    override fun uploadFiles(files: Flux<FilePart>): Mono<ResponseEntity<Any>> {
        return files
            .doOnNext { logger.info("saving -> {}", it.filename()) }
            .map { FileDocument().apply {
                this.filename = it.filename()
            } }
            .collectList()
            .flatMap { fileRepository.saveAll(it).then() }
            .then(Mono.just(ResponseEntity.ok(null)))
    }
}