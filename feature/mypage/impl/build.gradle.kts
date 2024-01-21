plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.mypage"
}

dependencies {
    implementation(projects.core.repo.signin.api)

    implementation(projects.feature.mainNavGraph)
    implementation(projects.feature.mypage.api)

    implementation(libs.kotlinx.immutable)
}
