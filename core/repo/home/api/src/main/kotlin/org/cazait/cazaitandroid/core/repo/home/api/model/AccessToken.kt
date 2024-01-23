package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class AccessToken(private val token: String) {
    fun asString(): String = token
}