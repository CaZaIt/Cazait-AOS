package org.cazait.cazaitandroid.core.model.cafe

@JvmInline
value class CafeImage(private val url: String) {
    fun asString(): String = url
}
