package org.cazait.cazaitandroid.core.repo.home.api.model

@JvmInline
value class DistanceLimit(private val distance: Int) {
    fun asInt(): Int = distance
    fun asString(): String = distance.toString()
}
