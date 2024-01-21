package org.cazait.cazaitandroid.core.repo.home.mapper

import org.cazait.cazaitandroid.core.local.recentview.model.CafeEntity
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeImage
import java.util.Date

internal fun Cafe.toEntity(date: Date): CafeEntity = CafeEntity(
    id = id.asUUID(),
    name = name.asString(),
    address = address.asString(),
    cafeImages = cafeImages.asList().map(CafeImage::asString),
    latitude = latitude.asDouble(),
    longitude = longitude.asDouble(),
    storedDate = date,
)
