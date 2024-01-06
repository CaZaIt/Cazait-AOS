plugins {
    id("cazait.android.library-no-hilt")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.cafedetail.api"
}

dependencies {
    implementation(projects.feature.mainNavGraph)
    implementation(libs.androidx.compose.navigation)
}
