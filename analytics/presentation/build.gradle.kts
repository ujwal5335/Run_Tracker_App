plugins {
    alias(libs.plugins.runtrackerapp.android.feature.ui)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.ujwal.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}