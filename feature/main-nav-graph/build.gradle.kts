plugins {
    id("cazait.android.library-no-hilt")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.nav"
}

dependencies {
    implementation(libs.androidx.compose.navigation)
}
