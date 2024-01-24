plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.session"
}

dependencies {
    implementation(projects.core.repo.signin.api)
    implementation(projects.core.local.user)
    implementation(libs.kotlinx.immutable)
}
