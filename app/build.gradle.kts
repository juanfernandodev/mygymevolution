plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.juanferdev.mygymevolution"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.juanferdev.mygymevolution"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val appcompatVersion = "1.6.1"
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    val activityCompose = "1.9.0"
    val navigationComposeVersion = "2.7.7"
    val composeBom = platform("androidx.compose:compose-bom:2024.01.00")
    val composeVersion = "1.6.6"
    val coreKtx = "1.13.0"
    val lifecycleRuntime = "2.7.0"

    implementation(project(":feature"))
    implementation("androidx.navigation:navigation-compose:${navigationComposeVersion}")
    implementation(composeBom)
    implementation("androidx.compose.runtime:runtime:${composeVersion}")
    implementation("androidx.compose.runtime:runtime-livedata:${composeVersion}")
    implementation("androidx.compose.runtime:runtime-rxjava2:${composeVersion}")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.core:core-ktx:${coreKtx}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleRuntime}")
    implementation("androidx.activity:activity-compose:${activityCompose}")
    implementation("androidx.compose.ui:ui-tooling-preview")
    androidTestImplementation(composeBom)
    debugImplementation("androidx.compose.ui:ui-tooling")

    //Hilt
    val versionHilt = "2.50"
    implementation("com.google.dagger:hilt-android:$versionHilt")
    kapt("com.google.dagger:hilt-android-compiler:$versionHilt")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}