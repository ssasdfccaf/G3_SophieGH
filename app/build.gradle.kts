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

    // 뷰 바인딩을 사용한다고 설정
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Firebase Auth
    implementation("com.google.firebase:firebase-auth-ktx")
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")


    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries
}