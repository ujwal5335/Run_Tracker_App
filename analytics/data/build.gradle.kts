plugins {
    alias(libs.plugins.runtrackerapp.android.library)
    alias(libs.plugins.runtrackerapp.android.room)
}

android {
    namespace = "com.ujwal.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}