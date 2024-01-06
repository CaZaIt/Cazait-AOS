package org.cazait.cazaitandroid.core.repo.cafedetail.api

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews

interface CafeDetailRepository {
    suspend fun getCafeMenus(): CafeMenus
    suspend fun getCafeReviews(): CafeReviews
}