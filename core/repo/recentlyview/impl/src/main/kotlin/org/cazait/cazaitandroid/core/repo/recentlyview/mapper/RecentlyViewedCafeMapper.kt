package org.cazait.cazaitandroid.core.repo.recentlyview.mapper

import org.cazait.cazaitandroid.core.local.recentview.model.CafeEntity
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeImage
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeImages
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafe

internal fun CafeEntity.toData(): RecentlyViewedCafe = RecentlyViewedCafe(
    id = CafeId(id),
    name = CafeName(name),
    address = CafeAddress(address),
    cafeImages = CafeImages(images = cafeImages.map(::CafeImage)),
    latitude = Latitude(latitude),
    longitude = Longitude(longitude),
)
