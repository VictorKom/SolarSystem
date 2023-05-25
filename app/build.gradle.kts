plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Versions.compileSdk
    namespace = AppConstants.appId

    defaultConfig {
        applicationId = AppConstants.appId
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

dependencies {

    // UI
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)

    // Firebase
    implementation(platform(Dependencies.Firebase.firebaseBom))
    implementation(Dependencies.Firebase.firestore)
    implementation(Dependencies.Firebase.storage)

    // Compose
    implementationCompose()
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.accompanistSystemUiController)
    implementation(Dependencies.accompanistPlaceholder)

    // Hilt
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltNavigation)

    //reflection
    implementation(Dependencies.kotlinReflect)
    implementation(Dependencies.gson)

    implementation(Dependencies.coil)
}