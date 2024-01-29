package org.cazait.cazaitandroid.core.model.cafe

@JvmInline
value class CafeImages(private val images: List<CafeImage>) {
    fun asList(): List<CafeImage> = images
}
