package org.cazait.cazaitandroid.core.model.cafe

@JvmInline
value class CafeAddress(private val address: String) {
    fun asString(): String = address
}
