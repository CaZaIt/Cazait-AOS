plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.session"
}

dependencies {
    implementation(libs.kotlinx.immutable)
}
