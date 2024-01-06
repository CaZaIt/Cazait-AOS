package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class MenuName(private val name: String) {
    fun asString(): String = name
}
