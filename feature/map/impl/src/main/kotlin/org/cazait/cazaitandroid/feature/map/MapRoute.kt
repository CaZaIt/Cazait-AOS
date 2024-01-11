package org.cazait.cazaitandroid.feature.map

import android.Manifest
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.flow.collectLatest
import org.cazait.cazaitandroid.core.location.extension.hasLocationPermission

@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun MapRoute(
    padding: PaddingValues,
    onShowErrorSnackbar: (Throwable?) -> Unit,
    viewModel: MapViewModel = hiltViewModel(),
) {
    val uiState: MapUiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val locationPermissionState =
        rememberMultiplePermissionsState(
            permissions = listOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

    LaunchedEffect(true) {
        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }
    LaunchedEffect(!context.hasLocationPermission()) {
        locationPermissionState.launchMultiplePermissionRequest()
    }
    when {
        locationPermissionState.allPermissionsGranted -> {
            LaunchedEffect(Unit) {
                viewModel.handlePermission(PermissionEvent.Granted)
            }
        }
    }

    MapScreen(
        padding = padding,
        mapUiState = uiState
    )
}