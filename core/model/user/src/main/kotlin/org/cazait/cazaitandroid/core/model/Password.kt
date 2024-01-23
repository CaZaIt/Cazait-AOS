package org.cazait.cazaitandroid.core.model

@JvmInline
value class Password(private val word: String) {
    fun asString(): String = word
}
