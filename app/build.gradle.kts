plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Add the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.firebasetest.g3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.firebasetest.g3"
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
        viewBinding = true
        dataBinding = true
    }

}

dependencies {
    val nav_version = "2.5.3"
    val lifecycle_version = "2.6.2"
    val activity_version = "1.6.1"

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /* dependencies for Firebase products I want to use */
    // Firebase Auth
    implementation("com.google.firebase:firebase-auth-ktx")

    // 파이어베이스 인증, 제공된 UI
    implementation ("com.firebaseui:firebase-ui-auth:7.2.0")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")

    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries




    // multiDex 임포트
    implementation ("androidx.multidex:multidex:2.0.1")

    // ViewModel - lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // LiveData: 옵저버 패턴 참조
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")




    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")


//    implementation 'com.google.code.gson:gson:2.8.9'
//    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//    implementation 'com.squareup.retrofit2:converter-gson:2.6.0'

    // retrofit 추가, gson 컨버터 추가
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // json 변환을 위한 또라이브러리, 예시 - gson
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


}