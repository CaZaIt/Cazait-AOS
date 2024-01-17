package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

import java.util.UUID

@JvmInline
value class UserId(private val id: UUID) {
    fun asUUID(): UUID = id
}