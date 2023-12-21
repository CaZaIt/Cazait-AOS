plugins {
    id("cazait.android.library")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.core.designsystem"
}

dependencies {
    implementation(libs.androidx.appcompat)
    
    implementation(libs.landscapist.bom)
    implementation(libs.landscapist.coil)
    implementation(libs.landscapist.placeholder)

    implementation(libs.androidx.glance)
}
