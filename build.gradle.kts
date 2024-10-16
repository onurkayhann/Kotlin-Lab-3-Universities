// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application" ) version "8.3.0" apply false

    // Update to matching KSP version
    id("org.jetbrains.kotlin.android" ) version "1.9.23" apply false

    // Devtools - KSP
    id("com.google.devtools.ksp" ) version "1.9.23-1.0.19"
}