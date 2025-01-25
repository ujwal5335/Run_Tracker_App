plugins {
    `kotlin-dsl`
}

group = "com.ujwal.run_tracker_app.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "runtrackerapp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "runtrackerapp.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "runtrackerapp.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "runtrackerapp.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidFeatureUi") {
            id = "runtrackerapp.android.feature.ui"
            implementationClass = "AndroidFeatureUiConventionPlugin"
        }

        register("androidRoom") {
            id = "runtrackerapp.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("androidDynamicFeature") {
            id = "runtrackerapp.android.dynamic.feature"
            implementationClass = "AndroidDynamicFeatureConventionPlugin"
        }

        register("JvmLibrary") {
            id = "runtrackerapp.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

        register("JvmKtor") {
            id = "runtrackerapp.jvm.ktor"
            implementationClass = "JvmKtorConventionPlugin"
        }

    }
}