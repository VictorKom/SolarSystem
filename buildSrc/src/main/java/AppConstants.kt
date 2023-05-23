object AppConstants {
    const val appId = "com.example.solarsystem"

    val coverageVerificationExcludePaths = listOf(
        // ui
        "**/compose/**",
        "**/*Preview*.*",
        "**/*MultistreamDestinationDialogs*.*",
        "**/presentation/permission/**",

        // localization
        "**/*Localization.*",
        "**/*LocalizationModule.*",
        "**/*RawStringKeys*.*",
        "**/*CommonKeys*.*",

        // Dagger/Hilt
        "**/di/**",
        "**/*Module*.*",
        "**/*Dagger*.*",
        "**/*Hilt*.*",
        "**/hilt_aggregated_deps/**",
        "**/*MembersInjector*.*",
        "**/*_MembersInjector.class",
        "**/*_Factory*.*",
        "**/*_Provide*Factory*.*",

        // data
        "**/data/work/**",
        "**/data/db/**",
        "**/*UploadFilesRepository*.*",
        "**/*StreamHelperImpl*.*",
        "**/*CountryRepositoryImpl*.*",
        "**/*StreamRepositoryImpl*.*",
        "**/*BrandRepositoryImpl*.*",
        "**/*CityRepositoryImpl*.*",
        "**/*CategoryRepositoryImpl*.*",
        "**/*NotificationsRepositoryImpl*.*",
        "**/*MainPageRepositoryImpl*.*",
        "**/*UnpackGRPCKt*.*",
        "**/*DataModel*.*",
        "**/*GrpcLogger*.*",
        "**/*AdvertiserRepositoryImpl*.*",

        // utils
        "**/developer_tools/**",
        "**/sniffer/**",
        "**/*VideoKt*.*",
        "**/*CustomLifecycle*.*",
        "**/*Extensions*.*",
        "**/*RedirectWebViewClient*.*",
        "**/*ConnectSocialNetworkRepository*.*",
        "**/*SearchRepository*.*",
        "**/*PersonalInfoBundle*.*",
        "**/*KeyboardContentSlider*.*",
        "**/extensions/Picker*.*",
        "**/test/**",

        // navigation
        "**/navigation/**",

        // main-page
        "**/main_page/**/models/**",

        // push (until don't work)
        "**/push/**",

        // my-works
        "**/my_works/**/AdvertisingCampaignPresentationModel",
        "**/my_works/**/CampaignBlockModel",
        "**/my_works/**/StatisticsPresentationModel",
        "**/my_works/**/StatusFilter",

        //stream-preparation
        "**/stream_preparation/domain/model/**",

        //create-campaign cover generation
        "**/StreamCoverGenerator*.*",
        "**/VideoFrameCreator*.*",
        "**/util/images/Utils*.*",

        // other
        "**/*CommonErrorWithButtonMessage*.*",
        "**/*Message*.*",
        "**/Image.*",
        "**/CostRange.*",
        "**/ProductItem*.*",
        "**/DeveloperToolsRepositoryImpl*.*",
        "**/Either*.*",
        "**/CameraFramesProducer*.*",
        "**/CameraInfo*.*",
        "**/CameraType*.*",
        "**/ViewPortCache*.*",
        "**/FramesRenderingPipeline*.*",
        "**/EncoderFramesConsumer*.*",
        "**/MediaPipeFramesConsumer*.*",
    )
    val compilerArgs = listOf(
        "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
        "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
        "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
        "-Xopt-in=androidx.compose.ui.text.ExperimentalTextApi",
        "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
        "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
        "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi"
    )
    val buildTimeMillis = System.currentTimeMillis()
}
