package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

@JvmInline
value class CafeName(private val name: String) {
    fun asString(): String = name
}