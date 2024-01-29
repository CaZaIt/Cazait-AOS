package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class ReviewContent(private val content: String) {
    fun asString(): String = content
}
