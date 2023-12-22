plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.map"
}

dependencies {
    implementation(libs.kotlinx.immutable)
}
