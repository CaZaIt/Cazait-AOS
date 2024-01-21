plugins {
    id("cazait.android.feature")
}

android {
    namespace = "com.cazait.cazaitandroid.feature.main"
}

dependencies {

    implementation(projects.feature.mainNavGraph)
    implementation(projects.feature.splash)
    implementation(projects.feature.signin)

    implementation(projects.feature.home.api)
    implementation(projects.feature.cafedetail.api)
    implementation(projects.feature.mypage.api)
    implementation(projects.feature.map.api)
    implementation(projects.feature.viewmore.api)
    implementation(projects.feature.recentlyview.api)

    implementation(libs.kotlinx.immutable)
    implementation(libs.androidx.appcompat)
}
