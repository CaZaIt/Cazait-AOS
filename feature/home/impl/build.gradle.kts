plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.home"
}

dependencies {
    implementation(projects.core.repo.home.api)
    implementation(projects.feature.home.api)

    implementation(projects.core.location)
    implementation(projects.feature.mainNavGraph)

    implementation(libs.accompanist.permissions)
    implementation(libs.play.services.location)
    implementation(libs.kotlinx.immutable)
}
