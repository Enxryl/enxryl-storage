package com.exzray.enxryl.storage.domain

import org.springframework.data.annotation.*
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("files")
class FileDocument {
    @Id
    lateinit var id: String

    lateinit var filename: String

    @CreatedBy
    lateinit var createdBy: String

    @CreatedDate
    lateinit var createdOn: LocalDateTime

    @LastModifiedBy
    lateinit var updatedBy: String

    @LastModifiedDate
    lateinit var updatedOn: LocalDateTime
}
