plugins {
    id("cazait.android.library")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.recentlyview.api"
}

dependencies {
    implementation(projects.feature.mainNavGraph)

    implementation(libs.androidx.compose.navigation)
}
