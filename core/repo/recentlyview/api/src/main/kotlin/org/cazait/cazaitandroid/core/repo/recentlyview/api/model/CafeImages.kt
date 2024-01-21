package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

@JvmInline
value class CafeImages(private val images: List<CafeImage>) {
    fun asList(): List<CafeImage> = images
}