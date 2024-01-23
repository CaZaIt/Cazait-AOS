package org.cazait.cazaitandroid.feature.home

import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes

internal sealed interface HomeAllCafesUiState {
    data object Loading : HomeAllCafesUiState

    data class Success(
        val congestionCafes: CongestionCafes,
    ) : HomeAllCafesUiState

    data object RevokedPermissions : HomeAllCafesUiState
}

internal sealed interface PermissionEvent {
    data object Granted : PermissionEvent
    data object Revoked : PermissionEvent
}
