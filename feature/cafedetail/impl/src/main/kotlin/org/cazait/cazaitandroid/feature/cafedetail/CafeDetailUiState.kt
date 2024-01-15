package org.cazait.cazaitandroid.feature.cafedetail

import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.Cafe
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

internal sealed interface CafeDetailInfoUiState {
    data object Loading : CafeDetailInfoUiState
    data class Success(
        val cafe: Cafe,
    ) : CafeDetailInfoUiState
}

internal enum class CafeDetailTab {
    MENU, REVIEW;

    fun switch() = when (this) {
        MENU -> REVIEW
        REVIEW -> MENU
    }
}

internal data class CafeDetailUiState(
    val menuUiState: CafeDetailMenuUiState = CafeDetailMenuUiState.Loading,
    val reviewUiState: CafeDetailReviewUiState = CafeDetailReviewUiState.Loading,
    val cafeDetailInfoUiState: CafeDetailInfoUiState = CafeDetailInfoUiState.Loading,
    val currentTab: CafeDetailTab = CafeDetailTab.MENU,
)
