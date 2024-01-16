package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class MenuPrice(private val price: Int) {
    fun asInt(): Int = price
}
