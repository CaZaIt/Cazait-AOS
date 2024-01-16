package org.cazait.cazaitandroid.core.repo.cafedetail

import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews
import org.cazait.cazaitandroid.core.repo.cafedetail.mapper.toData
import org.cazait.cazaitandroid.core.repo.cafedetail.network.CafeDetailApi
import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.CafeMenuResponse
import javax.inject.Inject

internal class DefaultCafeDetailRepository @Inject constructor(
    private val cafeDetailApi: CafeDetailApi,
) : CafeDetailRepository {
    override suspend fun getCafeMenus(cafeId: CafeId): CafeMenus = CafeMenus(
        cafeDetailApi.getCafeMenus(cafeId.asUUID().toString()).data.map(CafeMenuResponse::toData),
    )

    override suspend fun getCafeReviews(cafeId: CafeId): CafeReviews =
        cafeDetailApi.getCafeReviews(
            cafeId = cafeId.asUUID().toString(),
            sortBy = "newest",
            index = 0,
            nums = 50,
        ).data.toData()

    override suspend fun getCafeBy(cafeId: CafeId): Cafe =
        cafeDetailApi.getCafeBy(cafeId.asUUID().toString()).data.toData()
}
