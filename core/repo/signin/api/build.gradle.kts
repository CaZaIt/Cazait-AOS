plugins {
    id("cazait.coroutine.library")
    id("kotlinx-serialization")
}

dependencies {
    api(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
