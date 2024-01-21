package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

@JvmInline
value class CafeImages(private val images: List<CafeImage>) {
    val first: CafeImage?
        get() = images.firstOrNull()

    fun asList(): List<CafeImage> = images
}
