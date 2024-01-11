package org.cazait.cazaitandroid.feature.map

internal interface MapUiState {
    data object Loading: MapUiState
    data class Success(
        val cafes: Int = 1,
    ): MapUiState
}