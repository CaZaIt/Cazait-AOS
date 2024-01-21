plugins {
    id("cazait.android.feature")
}

android {
    namespace = "org.cazait.cazaitandroid.feature.recentlyview"
}

dependencies {
    implementation(projects.core.repo.recentlyview.api)
    implementation(projects.feature.recentlyview.api)
    implementation(projects.feature.mainNavGraph)
}
