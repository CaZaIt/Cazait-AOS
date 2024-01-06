package org.cazait.cazaitandroid.feature.home

import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes

internal sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val congestionCafes: CongestionCafes,
    ) : HomeUiState

    data object RevokedPermissions : HomeUiState
}

internal sealed interface PermissionEvent {
    data object Granted: PermissionEvent
    data object Revoked: PermissionEvent
}
