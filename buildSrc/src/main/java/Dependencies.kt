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


}