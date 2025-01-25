plugins {
    alias(libs.plugins.runtrackerapp.android.library)
    alias(libs.plugins.runtrackerapp.android.room)
}

android {
    namespace = "com.ujwal.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)
    implementation(libs.bundles.koin)
    implementation(projects.core.domain)

}