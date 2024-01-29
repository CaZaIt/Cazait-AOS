package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class CafeName(private val name: String) {
    fun asString(): String = name
}
