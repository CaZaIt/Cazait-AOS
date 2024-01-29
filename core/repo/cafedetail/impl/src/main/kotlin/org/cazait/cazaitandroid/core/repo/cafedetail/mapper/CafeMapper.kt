package org.cazait.cazaitandroid.core.repo.cafedetail.mapper

import org.cazait.cazaitandroid.core.model.cafe.CafeAddress
import org.cazait.cazaitandroid.core.model.cafe.CafeImage
import org.cazait.cazaitandroid.core.model.cafe.CafeImages
import org.cazait.cazaitandroid.core.model.cafe.CafeName
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeDetails
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Congestion
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Favorite
import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.CafeResponse

internal fun CafeResponse.toData(): CafeDetails = CafeDetails(
    name = CafeName(name),
    congestion = Congestion.valueOf(congestionStatus),
    address = CafeAddress(address),
    cafeImages = CafeImages(cafeImages.map(::CafeImage)),
    favorite = Favorite.valueOf(favoritesStatus),
)
