@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.pekka.android.application.compose")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ktlint)
}
android {
    namespace = "com.pekka.koreanwordclock"

    defaultConfig {
        applicationId = "com.pekka.koreanwordclock"
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

ktlint {
    android.set(true)
    outputColorName.set("RED")
}

dependencies {
    implementation(projects.common)
    implementation(projects.data)
    implementation(projects.dataLocal)

    implementation(libs.bundles.android)
    debugImplementation(libs.bundles.compose.debug)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.bundles.test.android)
}
