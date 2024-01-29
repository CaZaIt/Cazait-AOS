package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class Longitude(private val value: Double) {
    fun asDouble(): Double = value
    fun asString(): String = value.toString()
}
