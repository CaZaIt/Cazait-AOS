package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class Distance(private val value: Int) {
    fun asInt(): Int = value
}
