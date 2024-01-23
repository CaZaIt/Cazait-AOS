package org.cazait.cazaitandroid.core.model

@JvmInline
value class RefreshToken(private val token: String) {
    fun asString(): String = token
}
