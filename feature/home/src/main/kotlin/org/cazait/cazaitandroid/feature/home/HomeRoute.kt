package org.cazait.cazaitandroid.feature.home

import android.Manifest
import android.annotation.SuppressLint
import android.os.Looper
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var currentLocation by remember {
        mutableStateOf(LocationDetails(0.0, 0.0))
    }
    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }
    val locationCallback = remember {
        object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                for (lo in p0.locations) {
                    currentLocation = LocationDetails(
                        latitude = lo.latitude,
                        longitude = lo.longitude,
                    )
                }
            }
        }
    }
    val locationPermissionState =
        rememberMultiplePermissionsState(
            permissions =
            listOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

    LaunchedEffect(true) {
        locationPermissionState.launchMultiplePermissionRequest()
    }

    LaunchedEffect(key1 = locationPermissionState.allPermissionsGranted) {
        val locationRequest = LocationRequest.Builder(10000L)
            .setIntervalMillis(10000L)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
            .build()
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper(),
        )
    }

    LaunchedEffect(key1 = currentLocation) {
        homeViewModel.fetchCongestionCafes(
            latitude = currentLocation.latitude,
            longitude = currentLocation.longitude,
        )
    }

    LaunchedEffect(true) {
        homeViewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }

    HomeScreen(
        padding = padding,
        onClickCafe = {},
        uiState = uiState,
    )
}
