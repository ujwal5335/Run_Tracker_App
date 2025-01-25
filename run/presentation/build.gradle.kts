plugins {
    alias(libs.plugins.runtrackerapp.android.feature.ui)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mapsplatform.secrets.plugin)
}

android {
    namespace = "com.ujwal.run.presentation"
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.google.maps.android.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
}