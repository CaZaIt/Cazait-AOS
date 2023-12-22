pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CazaitAndroid"
include(
    ":app",
    ":core:domain",
    ":core:data",
    ":core:designsystem",
    ":core:ui",
    ":feature:signin",
    ":feature:splash",
    ":feature:home",
    ":feature:map",
    ":feature:mypage",
    ":feature:viewmore",
)
