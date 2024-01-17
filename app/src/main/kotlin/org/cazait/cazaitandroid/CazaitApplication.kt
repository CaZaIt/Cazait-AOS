package org.cazait.cazaitandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.cazait.cazaitandroid.feature.map.initNaverMapSdkClient

@HiltAndroidApp
class CazaitApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initNaverMapSdkClient()
    }
}
