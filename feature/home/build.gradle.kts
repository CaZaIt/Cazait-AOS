plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.home"
}

dependencies {
    implementation(projects.core.repo.home.api)

    implementation(libs.kotlinx.immutable)
}
