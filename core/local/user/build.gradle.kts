plugins {
    id("cazait.android.library")
    id("cazait.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "org.cazait.cazaitandroid.core.local.user"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.core.model.token)
    implementation(projects.core.model.user)

    implementation(libs.androidx.datastore)

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.coroutines.test)
}
