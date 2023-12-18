object Dependencies {


    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val runtimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coreKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeGraphicsUi by lazy { "androidx.compose.ui:ui-graphics" }
    val composePreviewUi by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3Ui by lazy { "androidx.compose.material3:material3" }
    val testComposeJunit by lazy { "junit:junit:${Versions.testComposeJunit}" }
    val testComposeJunitExt by lazy { "androidx.test.ext:junit:${Versions.testComposeJunitExt}" }
    val testEspresso by lazy { "androidx.test.espresso:espresso-core:${Versions.testEspresso}" }
    val testJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val debugToolingCompose by lazy { "androidx.compose.ui:ui-tooling" }
    val debugManifestCompose by lazy { "androidx.compose.ui:ui-test-manifest" }
    val lifecycleViewmodelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewmodelKtx}" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.matrial}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }

    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

}

object Modules{
    const val utilities = ":utilities"
}