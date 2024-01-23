package org.cazait.cazaitandroid.core.model

import java.util.UUID

@JvmInline
value class UserId(private val uuid: UUID) {
    fun asUUID(): UUID = uuid
    fun asString(): String = uuid.toString()
}
