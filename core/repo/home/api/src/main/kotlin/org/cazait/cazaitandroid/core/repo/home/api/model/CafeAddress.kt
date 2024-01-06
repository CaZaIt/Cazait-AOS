package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class CafeAddress(private val address: String) {
    fun asString(): String = address
}