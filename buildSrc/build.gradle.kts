plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.0.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    implementation("com.squareup:javapoet:1.13.0")
}
