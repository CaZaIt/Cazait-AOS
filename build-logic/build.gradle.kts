plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.verify.detektPlugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "cazait.android.hilt"
            implementationClass = "org.cazait.cazaitandroid.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "cazait.kotlin.hilt"
            implementationClass = "org.cazait.cazaitandroid.HiltKotlinPlugin"
        }
    }
}
