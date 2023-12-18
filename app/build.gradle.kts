plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ir.newsappmvvmcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "ir.newsappmvvmcompose"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.runtimeKtx)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeGraphicsUi)
    implementation(Dependencies.composePreviewUi)
    implementation(Dependencies.composeMaterial3Ui)
    testImplementation(Dependencies.testComposeJunit)
    androidTestImplementation(Dependencies.testComposeJunitExt)
    androidTestImplementation(Dependencies.testEspresso)
    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.testJunit4)
    debugImplementation(Dependencies.debugToolingCompose)
    debugImplementation(Dependencies.debugManifestCompose)

    implementation(Dependencies.lifecycleViewmodelKtx)
    implementation(Dependencies.navigationCompose)

    implementation(project(Modules.utilities))

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)

    implementation(Dependencies.hiltNavigationCompose)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)

    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
}

kapt {
    correctErrorTypes = true
}

