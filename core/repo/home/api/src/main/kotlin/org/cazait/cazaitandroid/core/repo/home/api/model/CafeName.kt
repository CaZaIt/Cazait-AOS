package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class CafeName(private val name: String) {
    fun asString(): String = name
}