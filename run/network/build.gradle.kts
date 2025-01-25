plugins {
    alias(libs.plugins.runtrackerapp.android.library)
    alias(libs.plugins.runtrackerapp.jvm.ktor)
}

android {
    namespace = "com.ujwal.run.network"
}

dependencies {
    implementation(libs.bundles.koin)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}