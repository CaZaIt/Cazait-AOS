plugins {
    id("cazait.android.library")
    id("cazait.android.hilt")
}

android {
    namespace = "org.cazait.cazaitandroid.core.http"
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.inject)
}
