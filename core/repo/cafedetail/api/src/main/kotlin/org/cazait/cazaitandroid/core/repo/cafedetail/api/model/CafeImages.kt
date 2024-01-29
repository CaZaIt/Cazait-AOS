package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

@JvmInline
value class CafeImages(private val images: List<CafeImage>) {
    fun asList(): List<CafeImage> = images
}
