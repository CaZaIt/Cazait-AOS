package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class FavoritesId(private val id: Int) {
    fun asInt(): Int = id
}
