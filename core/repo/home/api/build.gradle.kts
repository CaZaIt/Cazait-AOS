plugins {
    id("cazait.coroutine.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.core.model.token)

    api(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
