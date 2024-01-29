plugins {
    id("cazait.coroutine.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.core.model.token)
    implementation(projects.core.model.cafe)
    implementation(projects.core.model.user)

    implementation(libs.kotlinx.serialization.json)
}
