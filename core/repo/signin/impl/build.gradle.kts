plugins {
    id("cazait.android.library")
    id("cazait.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "org.cazait.cazaitandroid.core.repo.signin"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.core.repo.signin.api)
    implementation(projects.core.model.token)

    implementation(libs.androidx.datastore)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.coroutines.test)
}
