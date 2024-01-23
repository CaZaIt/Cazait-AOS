package org.cazait.cazaitandroid.core.repo.home.mapper

import org.cazait.cazaitandroid.core.repo.home.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeImage
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.home.api.model.Congestion
import org.cazait.cazaitandroid.core.repo.home.api.model.FavoritedCafe
import org.cazait.cazaitandroid.core.repo.home.api.model.FavoritesId
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.network.model.FavoritedCafeResponse
import java.util.UUID

internal fun FavoritedCafeResponse.toData(): FavoritedCafe = FavoritedCafe(
    favoritesId = FavoritesId(favoritesId),
    cafeId = CafeId(UUID.fromString(cafeId)),
    name = CafeName(name),
    address = CafeAddress(address),
    latitude = Latitude(latitude.toDouble()),
    longitude = Longitude(longitude.toDouble()),
    congestion = Congestion.valueOf(congestion),
    image = CafeImage(imageUrl),
)
