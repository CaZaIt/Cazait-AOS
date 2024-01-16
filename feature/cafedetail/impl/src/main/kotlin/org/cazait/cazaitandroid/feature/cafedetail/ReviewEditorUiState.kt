package org.cazait.cazaitandroid.feature.cafedetail

import androidx.compose.runtime.Stable

@Stable
data class ReviewEditorUiState(
    val rating: Int = 5,
    val review: String = "",
)
