package org.cazait.cazaitandroid.feature.cafedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeId
import java.util.UUID

@Composable
internal fun CafeDetailRoute(
    cafeId: UUID,
    onEditReviewClick: (cafeId: String) -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
    viewModel: CafeDetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.cafeDetailUiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.fetchCafeDetails(cafeId = CafeId(cafeId))
        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }
    CafeDetailScreen(
        onEditReviewClick = { onEditReviewClick(cafeId.toString()) },
        detailUiState = uiState,
    )
}
