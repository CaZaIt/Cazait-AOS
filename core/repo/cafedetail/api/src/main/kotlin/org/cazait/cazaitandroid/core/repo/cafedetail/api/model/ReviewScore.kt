package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class ReviewScore(private val score: Int) {
    fun asInt(): Int = score
}