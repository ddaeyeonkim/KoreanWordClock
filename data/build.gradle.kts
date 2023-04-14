plugins {
    id("com.pekka.android.library")
}

android {
    namespace = "com.pekka.data"
}

dependencies {
    implementation(projects.dataLocal)

    implementation(libs.hilt.core)
}
