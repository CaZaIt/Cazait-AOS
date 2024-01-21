plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.viewmore"
}

dependencies {
    implementation(projects.feature.viewmore.api)
    implementation(projects.feature.mainNavGraph)
    implementation(libs.oss.licenses)
    implementation(libs.kotlinx.immutable)
}
