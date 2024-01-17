package org.cazait.cazaitandroid.feature.map

import androidx.compose.runtime.Stable
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes

internal interface MapUiState {
    data object Loading : MapUiState

    @Stable
    data class Success(
        val cafes: CongestionCafes,
        val clickedCafe: CongestionCafe?,
    ) : MapUiState

    data object DeniedPermissions : MapUiState
}

internal sealed interface PermissionEvent {
    data object Granted : PermissionEvent
    data object Denied : PermissionEvent
}
