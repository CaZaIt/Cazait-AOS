package org.cazait.cazaitandroid.feature.cafedetail.usecase

import org.cazait.cazaitandroid.core.model.cafe.CafeId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeDetails
import javax.inject.Inject

internal interface GetCafeByIdUseCase {
    suspend operator fun invoke(cafeId: CafeId): CafeDetails
}

internal class GetCafeByIdUseCaseImpl @Inject constructor(
    private val cafeDetailRepository: CafeDetailRepository,
) : GetCafeByIdUseCase {
    override suspend fun invoke(cafeId: CafeId): CafeDetails {
        return cafeDetailRepository.getCafeBy(cafeId = cafeId)
    }
}
