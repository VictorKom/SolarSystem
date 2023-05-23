import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    // Core
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    // Ui
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
    const val accompanistFlowlayout =
        "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
    const val accompanistNavigationMaterial =
        "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
    const val accompanistPager =
        "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    const val accompanistPlaceholder =
        "com.google.accompanist:accompanist-placeholder:${Versions.accompanist}"

    // ViewModel lifecycle
    private const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    private const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    private const val lifecycleViewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    val viewModelLifecycle = arrayListOf<String>().apply {
        add(lifecycleViewModelKtx)
        add(lifecycleViewModelCompose)
        add(lifecycleViewModelSavedState)
    }

    object Firebase {
        const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBomVersion}"
        const val firestore = "com.google.firebase:firebase-firestore-ktx"
        const val storage = "com.google.firebase:firebase-storage-ktx"
    }

    // DI
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    // Navigation
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Compose
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    private const val composeCompiler =
        "androidx.compose.compiler:compiler:${Versions.composeCompiler}"

    const val composeBOM = "androidx.compose:compose-bom:${Versions.composeBOM}"
    const val composeUi = "androidx.compose.ui:ui"
    private const val composeFoundation = "androidx.compose.foundation:foundation"
    private const val composeMaterial = "androidx.compose.material:material"
    private const val composeTooling = "androidx.compose.ui:ui-tooling"
    val composeLibs = arrayListOf<String>().apply {
        add(composeCompiler)
        add(composeUi)
        add(composeFoundation)
        add(composeMaterial)
        add(composeTooling)
    }

    // Image loader
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.implementationCompose() {
    add("implementation", platform(Dependencies.composeBOM))
    implementation(Dependencies.composeLibs)
}
