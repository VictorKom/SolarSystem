buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.buildTools)
        classpath(Plugins.kotlin)
        classpath(Plugins.hilt)
        classpath(Plugins.gms)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    rootProject.subprojects {
        delete(buildDir)
    }
}
