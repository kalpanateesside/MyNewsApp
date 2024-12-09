plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "uk.ac.tees.mad.w9641722.mynewsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "uk.ac.tees.mad.w9641722.mynewsapp"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(libs.runtime.livedata)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Coil
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.gson)
    implementation(libs.okhttp) // Core OkHttp library
    implementation(libs.logging.interceptor)
    // Splash API
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:6.4.0")

    // Paging
    implementation("androidx.paging:paging-compose:3.3.1")

    // Firebase Auth
    implementation("com.google.firebase:firebase-auth-ktx:23.1.0")

    // Play Services Auth
    implementation("com.google.android.gms:play-services-auth:21.2.0")

    // Credentials
    implementation("androidx.credentials:credentials:1.2.2")
    implementation("androidx.credentials:credentials-play-services-auth:1.2.2")

    // Identity
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.1")

    // Firebase Firestore
    implementation("com.google.firebase:firebase-firestore:25.0.0")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Icons Extended
    implementation(libs.accompanist.systemuicontroller)
    implementation("androidx.compose.material:material:1.7.5")

}

kapt {
    correctErrorTypes = true
}