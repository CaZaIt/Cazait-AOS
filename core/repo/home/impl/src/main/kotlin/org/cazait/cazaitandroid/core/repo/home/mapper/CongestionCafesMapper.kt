package org.cazait.cazaitandroid.core.repo.home.mapper

import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeImage
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeImages
import org.cazait.cazaitandroid.core.repo.home.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.home.api.model.Congestion
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.Distance
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.network.model.CongestionCafeResponse
import java.util.UUID

internal fun List<CongestionCafeResponse>.toData(): CongestionCafes = CongestionCafes(
    values = map(CongestionCafeResponse::toData),
)

internal fun CongestionCafeResponse.toData(): CongestionCafe = CongestionCafe(
    cafe = Cafe(
        id = CafeId(UUID.fromString(cafeId)),
        name = CafeName(name),
        address = CafeAddress(address),
        cafeImages = CafeImages(cafeImages.map { CafeImage(it) }),
        latitude = Latitude(latitude.toDouble()),
        longitude = Longitude(longitude.toDouble()),
    ),
    congestion = Congestion.valueOf(congestionStatus),
    distance = Distance(distance),
)
