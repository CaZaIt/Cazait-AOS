plugins {
    id("cazait.android.library")
}

android {
    namespace = "org.cazait.cazaitandroid.core.testing"
}

dependencies {
    api(libs.junit4)
    api(libs.junit.vintage.engine)
    api(libs.kotlin.test)
    api(libs.mockk)
    api(libs.turbine)
    api(libs.coroutines.test)
}
