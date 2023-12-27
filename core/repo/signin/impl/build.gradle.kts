plugins {
    id("cazait.android.library")
    id("cazait.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "org.cazait.cazaitandroid.core.repo.signin"
}

dependencies {
    implementation(projects.core.repo.signin.api)

    implementation(libs.androidx.datastore)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.datetime)

    testImplementation(libs.junit4)
    testImplementation(libs.kotlin.test)
}
