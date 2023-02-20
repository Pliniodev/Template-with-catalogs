plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.plinio.dev.template"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.plinio.template"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0-alpha02"
    }
}

dependencies {

    // Compose
    implementation(libs.compose.compiler)
    implementation(libs.compose.runtime)
    implementation(libs.compose.ui)
    implementation(libs.compose.material.core)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.preview)
    implementation(libs.compose.animation)
    implementation(libs.compose.activity)

    // Compose Debug & Testing
    androidTestImplementation(libs.compose.test.junit)
    debugImplementation(libs.compose.debug.manifest)
    debugImplementation(libs.compose.debug.tooling)

    // AndroidX
    implementation(libs.androidX.core.ktx)
    implementation(libs.androidX.lifecycle.runtime)

    // Testing
    testImplementation(libs.testing.junit)
    testImplementation(libs.testing.mockk)

    // Ui Testing
    androidTestImplementation(libs.uiTesting.junit)
    androidTestImplementation(libs.uiTesting.espresso)

    // Hilt
    implementation(libs.hilt.core)
    kapt(libs.hilt.kapt)

    //navigation

    implementation(libs.voyager.navigator)
    implementation(libs.voyager.transition)
    implementation(libs.voyager.hilt)
    implementation(libs.voyager.androidX)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.database)
    implementation(libs.firebase.coroutines)
    implementation(libs.firebase.auth)
    implementation(libs.google.playservices.auth)
}

kapt {
    correctErrorTypes = true
}