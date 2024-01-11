package org.cazait.cazaitandroid.feature.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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

private val seoul = LatLng(37.532600, 127.024612)
private val initialPosition = CameraPosition(seoul, 11.0)

@OptIn(ExperimentalNaverMapApi::class)
@Composable
internal fun MapScreen(
    padding: PaddingValues,
) {
    var mapProperties by remember {
        mutableStateOf(
            MapProperties(
                locationTrackingMode = LocationTrackingMode.Follow,
            )
        )
    }
    var mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                isLocationButtonEnabled = true,
                isZoomGesturesEnabled = true,
            )
        )
    }
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = initialPosition
    }

    Box(
        Modifier
            .padding(padding)
            .fillMaxSize()) {
        NaverMap(
            cameraPositionState = cameraPositionState,
            locationSource = rememberFusedLocationSource(),
            properties = mapProperties,
            uiSettings = mapUiSettings,
        ) {
            Marker(
                state = MarkerState(position = LatLng(37.532600, 127.024612)),
                captionText = "Marker in Seoul"
            )
            Marker(
                state = MarkerState(position = LatLng(37.390791, 127.096306)),
                captionText = "Marker in Pangyo"
            )
        }
        Column {
            Button(onClick = {
                mapProperties = mapProperties.copy(
                    isBuildingLayerGroupEnabled = !mapProperties.isBuildingLayerGroupEnabled
                )
            }) {
                Text(text = "Toggle isBuildingLayerGroupEnabled")
            }
            Button(onClick = {
                mapUiSettings = mapUiSettings.copy(
                    isLocationButtonEnabled = !mapUiSettings.isLocationButtonEnabled
                )
            }) {
                Text(text = "Toggle isLocationButtonEnabled")
            }
        }
    }
}