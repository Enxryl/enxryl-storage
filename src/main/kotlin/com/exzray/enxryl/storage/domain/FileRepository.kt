package com.exzray.enxryl.storage.domain

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository: ReactiveMongoRepository<FileDocument, String> {
}