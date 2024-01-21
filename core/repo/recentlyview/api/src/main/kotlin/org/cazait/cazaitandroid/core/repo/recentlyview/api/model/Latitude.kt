package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

@JvmInline
value class Latitude(private val value: Double) {
    fun asDouble(): Double = value
    fun asString(): String = value.toString()
}