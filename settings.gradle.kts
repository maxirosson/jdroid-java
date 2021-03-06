plugins {
    id("com.gradle.enterprise").version("3.5")
}

include(":jdroid-java-core")
include(":jdroid-java-firebase-admin")
include(":jdroid-java-firebase-database")
include(":jdroid-java-firebase-firestore")
include(":jdroid-java-remote-config")

apply(from = java.io.File(settingsDir, "buildCacheSettings.gradle"))
