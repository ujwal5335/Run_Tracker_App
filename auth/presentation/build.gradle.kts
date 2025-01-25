plugins {
    alias(libs.plugins.runtrackerapp.android.feature.ui)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.ujwal.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}