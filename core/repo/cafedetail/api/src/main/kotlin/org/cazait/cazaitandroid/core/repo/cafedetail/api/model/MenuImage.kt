package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class MenuImage(private val image: String) {
    fun asString(): String = image
}
