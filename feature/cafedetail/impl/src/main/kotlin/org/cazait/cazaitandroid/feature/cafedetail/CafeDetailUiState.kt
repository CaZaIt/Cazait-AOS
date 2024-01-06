package org.cazait.cazaitandroid.feature.cafedetail

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeReviews

internal sealed interface CafeDetailMenuUiState {
    data object Loading : CafeDetailMenuUiState
    data class Success(
        val cafeMenus: CafeMenus,
    ) : CafeDetailMenuUiState
}

internal sealed interface CafeDetailReviewUiState {
    data object Loading : CafeDetailReviewUiState
    data class Success(
        val cafeReviews: CafeReviews,
    ) : CafeDetailReviewUiState
}

internal data class CafeDetailUiState(
    val menuUiState: CafeDetailMenuUiState = CafeDetailMenuUiState.Loading,
    val reviewUiState: CafeDetailReviewUiState = CafeDetailReviewUiState.Loading,
)
