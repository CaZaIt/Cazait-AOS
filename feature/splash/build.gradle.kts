plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.splash"
}

dependencies {
    implementation(projects.core.repo.signin.api)

    implementation(libs.kotlinx.immutable)
}
