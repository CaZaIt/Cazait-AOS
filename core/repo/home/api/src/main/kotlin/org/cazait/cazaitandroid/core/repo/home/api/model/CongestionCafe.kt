package org.cazait.cazaitandroid.core.repo.home.api.model

data class CongestionCafe(
    val cafe: Cafe,
    val congestion: Congestion,
)

@JvmInline
value class CongestionCafes(private val values: List<CongestionCafe>) {
    fun asList(): List<CongestionCafe> = values
}

enum class Congestion { FREE, NORMAL, CLOSE, CROWDED, VERY_CROWDED }
