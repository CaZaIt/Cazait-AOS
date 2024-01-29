plugins {
    id("cazait.coroutine.library")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.core.model.token)
    implementation(projects.core.model.user)
    implementation(projects.core.model.cafe)

    api(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
