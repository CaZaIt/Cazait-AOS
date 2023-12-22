plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.home"
}

dependencies {
    implementation(libs.kotlinx.immutable)
}
