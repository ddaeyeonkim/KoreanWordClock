import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.pekka.koreanwordclock.configureAndroidCompose
import com.pekka.koreanwordclock.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
            }
        }
    }
}
