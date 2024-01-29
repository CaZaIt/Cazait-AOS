package org.cazait.cazaitandroid.feature.cafedetail.usecase

import org.cazait.cazaitandroid.core.model.cafe.CafeId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews
import javax.inject.Inject

internal interface GetCafeReviewsUseCase {
    suspend operator fun invoke(cafeId: CafeId): CafeReviews
}

internal class GetCafeReviewsUseCaseImpl @Inject constructor(
    private val cafeDetailRepository: CafeDetailRepository,
) : GetCafeReviewsUseCase {
    override suspend fun invoke(cafeId: CafeId): CafeReviews {
        return cafeDetailRepository.getCafeReviews(cafeId)
    }
}
