plugins {
    id("com.pekka.android.library")
}

android {
    namespace = "com.pekka.data.local"
}

dependencies {
    implementation(libs.hilt.core)
}
