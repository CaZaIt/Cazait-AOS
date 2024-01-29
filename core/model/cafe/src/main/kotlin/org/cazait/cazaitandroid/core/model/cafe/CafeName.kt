package org.cazait.cazaitandroid.core.model.cafe

@JvmInline
value class CafeName(private val name: String) {
    fun asString(): String = name
}
