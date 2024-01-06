package org.cazait.cazaitandroid.core.repo.cafedetail

import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews
import javax.inject.Inject

internal class DefaultCafeDetailRepository @Inject constructor() : CafeDetailRepository {
    override suspend fun getCafeMenus(): CafeMenus {
        TODO("Not yet implemented")
    }

    override suspend fun getCafeReviews(): CafeReviews {
        TODO("Not yet implemented")
    }
}