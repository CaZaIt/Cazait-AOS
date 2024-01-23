plugins {
    id("cazait.coroutine.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.core.model.token)
    implementation(projects.core.model.user)

    api(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
