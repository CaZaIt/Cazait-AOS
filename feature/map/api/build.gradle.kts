plugins {
    id("cazait.android.library")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.map.api"
}

dependencies {

    implementation(libs.androidx.compose.navigation)
}
