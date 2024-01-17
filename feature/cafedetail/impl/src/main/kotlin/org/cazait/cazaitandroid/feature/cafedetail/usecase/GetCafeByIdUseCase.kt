package org.cazait.cazaitandroid.feature.cafedetail.usecase

import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeId
import javax.inject.Inject

internal interface GetCafeByIdUseCase {
    suspend operator fun invoke(cafeId: CafeId): Cafe
}

internal class GetCafeByIdUseCaseImpl @Inject constructor(
    private val cafeDetailRepository: CafeDetailRepository,
) : GetCafeByIdUseCase {
    override suspend fun invoke(cafeId: CafeId): Cafe {
        return cafeDetailRepository.getCafeBy(cafeId = cafeId)
    }
}
