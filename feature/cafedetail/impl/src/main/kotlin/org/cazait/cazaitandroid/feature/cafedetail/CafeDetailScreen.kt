package org.cazait.cazaitandroid.feature.cafedetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun CafeDetailScreen(
    uiState: CafeDetailUiState,
) {
    if (uiState.menuUiState is CafeDetailMenuUiState.Success) {
        Text(text = uiState.menuUiState.cafeMenus.toString())
    }
}