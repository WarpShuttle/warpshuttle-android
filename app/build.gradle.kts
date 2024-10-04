plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.android.warpshuttle"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.android.warpshuttle"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("Boolean", "DEBUG_MODE", "true")
            buildConfigField("String", "BASE_URL", "\"http://localhost:8080/api/v1/\"")
            buildConfigField("String", "API_VERSION", "\"2.0.0\"")
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
        buildConfig = true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.runtime)
    implementation(libs.androidx.core.splash.screen)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.material)
    implementation(libs.androidx.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.andoridx.datastore)

    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.navigation.material)
    implementation(libs.accompanist.navigation.animation)

    implementation(libs.navigation.compose)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.dynamic.features)

    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.kotlin.coroutines)

    implementation(libs.facebook.stetho)
    implementation(libs.facebook.okhttp)

    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.okhttp.logging.interceptor)
    implementation(libs.androidx.constraintlayout.compose.android)

    implementation(libs.io.coil)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}