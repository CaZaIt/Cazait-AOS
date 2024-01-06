import  org.cazait.cazaitandroid.configureCoroutineAndroid
import  org.cazait.cazaitandroid.configureHiltAndroid
import org.cazait.cazaitandroid.configureKotest
import org.cazait.cazaitandroid.configureKotlinAndroid

plugins {
    id("com.android.library")
    id("cazait.verify.detekt")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
