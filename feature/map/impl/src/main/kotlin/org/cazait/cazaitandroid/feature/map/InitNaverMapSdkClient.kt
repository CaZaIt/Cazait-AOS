package org.cazait.cazaitandroid.feature.map

import android.app.Application
import com.naver.maps.map.NaverMapSdk

fun Application.initNaverMapSdkClient() {
    NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient(
        BuildConfig.naverMapsClientId,
    )
}
