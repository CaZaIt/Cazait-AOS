package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class Latitude(private val value: Double) {
    fun asDouble(): Double = value
}