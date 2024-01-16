package org.cazait.cazaitandroid.feature.cafedetail

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews

internal sealed interface CafeDetailUiState {
    data object Loading : CafeDetailUiState
    data class Success(
        val menus: CafeMenus,
        val reviews: CafeReviews,
        val cafeDetailInfo: Cafe,
    ) : CafeDetailUiState
}