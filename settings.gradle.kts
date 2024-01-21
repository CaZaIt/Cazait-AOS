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
        maven("https://naver.jfrog.io/artifactory/maven/")
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
    ":core:repo:cafedetail:impl",

    ":core:domain",
    ":core:data",
    ":core:designsystem",
    ":core:ui",
    ":core:http",
    ":core:testing",
    ":core:location",
    ":core:http-handle",

    ":feature:main",
    ":feature:main-nav-graph",
    ":feature:signin",
    ":feature:splash",

    ":feature:home:impl",
    ":feature:home:api",

    ":feature:map:impl",
    ":feature:map:api",

    ":feature:mypage:impl",
    ":feature:mypage:api",

    ":feature:cafedetail:impl",
    ":feature:cafedetail:api",

    ":feature:viewmore:impl",
    ":feature:viewmore:api",
)
