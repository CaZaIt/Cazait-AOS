import gradle.kotlin.dsl.accessors._9885c8525475a2a77e0b650bdf1e3c81.androidTestImplementation
import gradle.kotlin.dsl.accessors._9885c8525475a2a77e0b650bdf1e3c81.implementation
import org.cazait.cazaitandroid.configureHiltAndroid
import org.cazait.cazaitandroid.configureKotestAndroid
import org.cazait.cazaitandroid.configureKotlinAndroid
import org.cazait.cazaitandroid.libs

plugins {
    id("com.android.application")
    id("cazait.android.compose")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()

dependencies {
    val libs = project.extensions.libs
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    androidTestImplementation(libs.findLibrary("androidx.compose.navigation.test").get())

    implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
    implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
}
