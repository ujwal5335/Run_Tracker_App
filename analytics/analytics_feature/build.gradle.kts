plugins {
    alias(libs.plugins.runtrackerapp.android.dynamic.feature)
    alias(libs.plugins.compose.compiler)
}
android {
    namespace = "com.ujwal.analytics.analytics_feature"
}

dependencies {
    implementation(project(":app"))
    implementation(libs.androidx.navigation.compose)

    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)
}