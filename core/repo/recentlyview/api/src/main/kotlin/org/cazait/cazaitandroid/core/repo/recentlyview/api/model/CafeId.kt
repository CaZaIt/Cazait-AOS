package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

import java.util.UUID

@JvmInline
value class CafeId(private val id: UUID) {
    fun asUUID(): UUID = id
}
