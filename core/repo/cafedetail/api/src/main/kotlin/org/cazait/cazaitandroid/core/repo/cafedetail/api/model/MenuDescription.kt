package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class MenuDescription(private val description: String) {
    fun asString(): String = description
}