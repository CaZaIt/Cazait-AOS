plugins {
    id("cazait.android.library")
    id("cazait.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "org.cazait.cazaitandroid.core.repo.home"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.core.repo.home.api)
    implementation(projects.core.local.recentview)
    implementation(projects.core.model.token)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.coroutines.test)
}
