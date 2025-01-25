import com.android.build.api.dsl.ApplicationExtension
import com.ujwal.convention.ExtensionType
import com.ujwal.convention.configureBuildTypes
import com.ujwal.convention.configureKotlinAndroid
import com.ujwal.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.findVersion("projectApplicationId").get().toString()
                    versionName = libs.findVersion("projectVersionName").get().toString()
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
                }
                configureKotlinAndroid(this)

                configureBuildTypes(this, ExtensionType.APPLICATION)
            }
        }
    }
}