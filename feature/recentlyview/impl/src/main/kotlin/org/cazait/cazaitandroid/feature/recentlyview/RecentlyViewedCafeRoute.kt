package org.cazait.cazaitandroid.feature.recentlyview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun RecentlyViewedCafeRoute(
    onCafeClick: (cafeId: String) -> Unit,
    onBackButtonClick: () -> Unit,
    viewModel: RecentlyViewedCafeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val cafes = uiState.asList().toImmutableList()

    RecentlyViewedCafeScreen(
        cafes = cafes,
        onCafeClick = onCafeClick,
        onBackButtonClick = onBackButtonClick,
    )
}
