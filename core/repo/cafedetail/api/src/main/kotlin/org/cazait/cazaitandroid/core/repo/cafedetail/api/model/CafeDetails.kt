package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

import org.cazait.cazaitandroid.core.model.cafe.CafeAddress
import org.cazait.cazaitandroid.core.model.cafe.CafeImages
import org.cazait.cazaitandroid.core.model.cafe.CafeName

data class CafeDetails(
    val name: CafeName,
    val congestion: Congestion,
    val address: CafeAddress,
    val cafeImages: CafeImages,
    val favorite: Favorite,
)
