package org.cazait.cazaitandroid

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCazaitException() {
    dependencies {
        "implementation"(project(":core:http-handle"))
    }
}
