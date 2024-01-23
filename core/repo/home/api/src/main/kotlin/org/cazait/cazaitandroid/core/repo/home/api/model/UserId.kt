package org.cazait.cazaitandroid.core.repo.home.api.model

import java.util.UUID

@JvmInline
value class UserId(private val id: UUID) {
    fun asUUID(): UUID = id
    fun asString(): String = id.toString()
}
