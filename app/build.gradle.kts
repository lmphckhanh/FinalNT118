val implementation: Unit
    get() {
        TODO()
    }

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.afinal"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.afinal"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }
}

dependencies {
    implementation("com.google.android.material:material:1.12.0@aar")
    implementation ("com.google.firebase:firebase-auth:22.0.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation ("com.google.android.gms:play-services-maps:18.1.0")

    implementation("com.google.android.gms:play-services-maps:19.0.0")


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.play.services.maps)
    implementation(libs.car.ui.lib)
    implementation(libs.firebase.auth)
    implementation(libs.play.services.location)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


}