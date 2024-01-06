package org.cazait.cazaitandroid.feature.home

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.collectLatest
import org.cazait.cazaitandroid.core.location.extension.hasLocationPermission
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe

private val permissions = persistentListOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onCafeClick: (Cafe) -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val locationPermissionState = rememberMultiplePermissionsState(permissions)

    LaunchedEffect(true) {
        homeViewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }
    LaunchedEffect(!context.hasLocationPermission()) {
        locationPermissionState.launchMultiplePermissionRequest()
    }
    if (locationPermissionState.allPermissionsGranted) {
        LaunchedEffect(Unit) {
            homeViewModel.handlePermission(PermissionEvent.Granted)
        }
    }

    HomeScreen(
        padding = padding,
        onClickCafe = onCafeClick,
        uiState = uiState,
    )
}
