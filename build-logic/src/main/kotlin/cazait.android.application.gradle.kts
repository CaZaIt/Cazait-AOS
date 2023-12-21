import org.cazait.cazaitandroid.configureHiltAndroid
import org.cazait.cazaitandroid.configureKotestAndroid
import org.cazait.cazaitandroid.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()
