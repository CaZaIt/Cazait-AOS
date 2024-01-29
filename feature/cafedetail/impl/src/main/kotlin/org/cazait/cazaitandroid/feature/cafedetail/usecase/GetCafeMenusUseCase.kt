package org.cazait.cazaitandroid.feature.cafedetail.usecase

import org.cazait.cazaitandroid.core.model.cafe.CafeId
import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import javax.inject.Inject

internal interface GetCafeMenusUseCase {
    suspend operator fun invoke(cafeId: CafeId): CafeMenus
}

internal class GetCafeMenusUseCaseImpl @Inject constructor(
    private val cafeDetailRepository: CafeDetailRepository,
) : GetCafeMenusUseCase {
    override suspend fun invoke(cafeId: CafeId): CafeMenus {
        return cafeDetailRepository.getCafeMenus(cafeId)
    }
}
