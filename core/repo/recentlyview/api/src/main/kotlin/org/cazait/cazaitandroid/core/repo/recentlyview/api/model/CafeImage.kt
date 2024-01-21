package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

@JvmInline
value class CafeImage(private val url: String) {
    fun asString(): String = url
}