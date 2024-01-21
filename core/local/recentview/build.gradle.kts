plugins {
    id("cazait.android.library")
    id("cazait.android.hilt")
}

android {
    namespace = "org.cazait.cazaitandroid.core.local.recentview"
}

dependencies {
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
}
