plugins {
    alias(libs.plugins.runtrackerapp.android.library)
    alias(libs.plugins.runtrackerapp.jvm.ktor)
}

android {
    namespace = "com.ujwal.core.data"
}

dependencies {
    implementation(libs.timber)
    implementation(libs.bundles.koin)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}