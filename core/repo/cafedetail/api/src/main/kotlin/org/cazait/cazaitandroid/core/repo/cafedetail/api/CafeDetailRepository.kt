package org.cazait.cazaitandroid.core.repo.cafedetail.api

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews

interface CafeDetailRepository {
    suspend fun getCafeMenus(cafeId: CafeId): CafeMenus
    suspend fun getCafeReviews(cafeId: CafeId): CafeReviews
    suspend fun getCafeBy(cafeId: CafeId): Cafe
}
