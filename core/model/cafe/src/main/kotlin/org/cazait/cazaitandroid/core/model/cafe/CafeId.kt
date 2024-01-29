package org.cazait.cazaitandroid.core.model.cafe

import java.util.UUID

@JvmInline
value class CafeId(private val id: UUID) {
    fun asUUID(): UUID = id
}
