import androidx.room.gradle.RoomExtension
import com.ujwal.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                "implementation"(project.libs.findLibrary("room.runtime").get())
                "implementation"(project.libs.findLibrary("room.ktx").get())
                "ksp"(project.libs.findLibrary("room.compiler").get())
            }
        }
    }
}