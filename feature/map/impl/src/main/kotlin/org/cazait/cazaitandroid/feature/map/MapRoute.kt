package org.cazait.cazaitandroid.feature.map

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.flow.collectLatest

private val permissions = listOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION,
)

@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun MapRoute(
    padding: PaddingValues,
    onShowErrorSnackbar: (Throwable?) -> Unit,
    viewModel: MapViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) {
        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }

    val uiState: MapUiState by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current
    val permissionState = rememberMultiplePermissionsState(permissions) { permissionResults ->
        val needToSetting = permissionResults.filter {
            !ActivityCompat.shouldShowRequestPermissionRationale(
                context.findActivity(),
                it.key,
            ) && !it.value
        }.isNotEmpty()
        if (needToSetting) {
            viewModel.handlePermission(PermissionEvent.Denied)
        }
    }
    LaunchedEffect(key1 = Unit) {
        permissionState.launchMultiplePermissionRequest()
    }
    LaunchedEffect(permissionState.allPermissionsGranted) {
        if (permissionState.allPermissionsGranted) {
            viewModel.handlePermission(PermissionEvent.Granted)
        } else {
            viewModel.handlePermission(PermissionEvent.Denied)
        }
    }

    MapScreen(
        padding = padding,
        uiState = uiState,
        onClickCafe = viewModel::onClickCafe
    )
}

internal fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    error("Permissions should be called in the context of an Activity")
}
