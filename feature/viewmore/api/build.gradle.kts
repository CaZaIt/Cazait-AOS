plugins {
    id("cazait.android.library-no-hilt")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.viewmore.api"
}

dependencies {
    implementation(projects.feature.mainNavGraph)
    implementation(libs.androidx.compose.navigation)
}
