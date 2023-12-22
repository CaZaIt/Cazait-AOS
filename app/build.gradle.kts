plugins {
    id("cazait.android.application")
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    namespace = "org.cazait.cazaitandroid"

    defaultConfig {
        applicationId = "org.cazait.cazaitandroid"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.mypage)
    implementation(projects.feature.home)
    implementation(projects.feature.viewmore)
    implementation(projects.feature.map)
    implementation(projects.feature.signin)
    implementation(projects.feature.splash)
    implementation(libs.androidx.appcompat)
}
