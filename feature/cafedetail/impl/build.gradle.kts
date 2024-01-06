plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.cafedetail"
}

dependencies {
    implementation(projects.feature.mainNavGraph)
    implementation(projects.feature.cafedetail.api)
    implementation(libs.kotlinx.immutable)
}
