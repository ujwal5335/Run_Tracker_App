plugins {
    alias(libs.plugins.runtrackerapp.android.library)
    alias(libs.plugins.runtrackerapp.jvm.ktor)
}

android {
    namespace = "com.ujwal.auth.data"
}

dependencies {

    implementation(libs.bundles.koin)

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}