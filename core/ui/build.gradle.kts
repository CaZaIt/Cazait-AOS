plugins {
    id("cazait.android.library")
    id("cazait.android.compose")
}

android {
    namespace = "org.cazait.cazaitandroid.core.ui"
}

dependencies {
    implementation(projects.core.designsystem)
}
