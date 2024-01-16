package org.cazait.cazaitandroid.core.repo.cafedetail.mapper

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeImage
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeImages
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeName
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Congestion
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Favorite
import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.CafeResponse

internal fun CafeResponse.toData(): Cafe = Cafe(
    name = CafeName(name),
    congestion = Congestion.valueOf(congestionStatus),
    address = CafeAddress(address),
    cafeImages = CafeImages(cafeImages.map(::CafeImage)),
    favorite = Favorite.valueOf(favoritesStatus)
)