plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.avoxis.diskominfointerview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.avoxis.diskominfointerview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true

    }
    buildTypes {
        debug {
//            buildConfigField("String", "SERVER", "\"http://172.16.16.77:3008\"")
            buildConfigField("String", "SERVER", "\"https://ka2xhyaymy.jogjaprov.go.id/api/widget/\"")
            buildConfigField("String", "STATIC_TOKEN_V2",
                "\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBfaWQiOjEsImF1dGhvcml6ZWQiOnRydWUsImV4cCI6MTczNDY2NDUwNn0.oJIUBtK822BjBmNPUIVdZCX6Ga8r8g429symIg2m_fE\""
            )
        }
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.3.0")

    //RxJava
    implementation ("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.3.0")

    //OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.0")

    annotationProcessor ("androidx.lifecycle:lifecycle-compiler:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.7.0")

    implementation ("com.loopj.android:android-async-http:1.4.9")

    implementation ("com.jakewharton.timber:timber:4.7.1")
}