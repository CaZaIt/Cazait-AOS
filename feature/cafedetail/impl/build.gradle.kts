plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.cafedetail"
}

dependencies {
    implementation(projects.core.repo.cafedetail.api)
    implementation(projects.core.local.user)
    implementation(projects.feature.mainNavGraph)
    implementation(projects.feature.cafedetail.api)

    implementation(libs.toolbar.compose)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.kotlinx.immutable)
}
