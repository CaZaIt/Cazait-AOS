package org.cazait.cazaitandroid.core.model

@JvmInline
value class AccountName(private val name: String) {
    fun asString(): String = name
}
