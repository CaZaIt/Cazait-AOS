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

    ":core:repo:signin:api",
    ":core:repo:signin:impl",
    ":core:repo:home:api",
    ":core:repo:home:impl",
    ":core:repo:cafedetail:api",

    ":core:domain",
    ":core:data",
    ":core:designsystem",
    ":core:ui",
    ":core:http",
    ":core:testing",
    ":core:location",

    ":feature:main-nav-graph",
    ":feature:signin",
    ":feature:splash",
    ":feature:home",
    ":feature:map",
    ":feature:mypage",
    ":feature:viewmore",
    ":feature:cafedetail:impl",
    ":feature:cafedetail:api",
)
