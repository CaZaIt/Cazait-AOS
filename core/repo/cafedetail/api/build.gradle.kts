plugins {
    id("cazait.coroutine.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.core.model.token)

    implementation(libs.kotlinx.serialization.json)
}
