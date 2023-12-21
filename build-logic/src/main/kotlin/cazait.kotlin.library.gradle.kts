import org.cazait.cazaitandroid.configureKotest
import org.cazait.cazaitandroid.configureKotlin

plugins {
    kotlin("jvm")
    id("cazait.verify.detekt")
}

configureKotlin()
configureKotest()
