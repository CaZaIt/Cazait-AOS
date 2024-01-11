import java.util.Properties

plugins {
    id("cazait.android.feature")
}

val properties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

android {
    namespace = "org.cazait.cazaitandroid.feature.map"

    defaultConfig {
        buildConfigField(
            type = "String",
            name = "naverMapsClientId",
            value = properties.getProperty("naverMapsClientId")
        )
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.repo.home.api)
    implementation(projects.core.location)

    implementation(libs.accompanist.permissions)
    implementation(libs.play.services.location)
    implementation(libs.naver.map.compose)
    implementation(libs.naver.map.location)
    implementation(libs.naver.map.sdk)
    implementation(libs.kotlinx.immutable)
}
