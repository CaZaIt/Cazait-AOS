package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class MenuId(private val id: Int) {
    fun asInt(): Int = id
}