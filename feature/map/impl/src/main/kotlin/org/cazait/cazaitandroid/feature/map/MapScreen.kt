package org.cazait.cazaitandroid.feature.map

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.CameraPositionState
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.LocationTrackingMode
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import com.naver.maps.map.compose.rememberFusedLocationSource
import com.naver.maps.map.overlay.OverlayImage
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafe
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude

private val seoul = LatLng(37.532600, 127.024612)
private val initialPosition = CameraPosition(seoul, 11.0)

@Composable
internal fun MapScreen(
    padding: PaddingValues,
    uiState: MapUiState,
    onClickCafe: (CongestionCafe) -> Unit,
    onClickMap: () -> Unit,
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
    ) {
        MapScreen(
            uiState = uiState,
            onClickCafe = onClickCafe,
            onClickMap = onClickMap,
        )
        if (uiState is MapUiState.DeniedPermissions) {
            PermissionRequireBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 30.dp),
                onClick = {
                    val intent = Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + context.packageName),
                    )
                    context.startActivity(intent)
                },
            )
        }
    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
internal fun MapScreen(
    uiState: MapUiState,
    onClickCafe: (CongestionCafe) -> Unit,
    onClickMap: () -> Unit,
    onClickCafeDetail: () -> Unit = {},
) {
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = initialPosition
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        NaverMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            locationSource = rememberFusedLocationSource(),
            properties = MapProperties(locationTrackingMode = LocationTrackingMode.NoFollow),
            uiSettings = MapUiSettings(
                isLocationButtonEnabled = true,
                isZoomGesturesEnabled = true,
            ),
            onMapClick = { _, _ -> onClickMap() },
        ) {
            if (uiState is MapUiState.Success) {
                uiState.cafes.asList().forEach { store ->
                    Marker(
                        state = MarkerState(
                            position = store.toLatLng(),
                        ),
                        icon = OverlayImage.fromResource(
                            if (uiState.clickedCafe == store) {
                                R.drawable.ic_marker_clicked
                            } else {
                                R.drawable.ic_marker
                            },
                        ),
                        tag = store,
                        onClick = {
                            onClickCafe(it.tag as CongestionCafe)
                            true
                        },
                    )
                }
            }
        }
        if (uiState is MapUiState.Success) {
            uiState.clickedCafe?.let {
                MarkerDetailCard(
                    cafe = it,
                    onClick = { onClickCafeDetail() },
                )
            }
        }
    }
}

internal fun LatLng(latitude: Latitude, longitude: Longitude): LatLng =
    LatLng(latitude.asDouble(), longitude.asDouble())

internal fun CongestionCafe.toLatLng(): LatLng = LatLng(
    latitude = cafe.latitude,
    longitude = cafe.longitude,
)
