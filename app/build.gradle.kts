plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.nuevoproyecto"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.nuevoproyecto"
        minSdk = 24
        targetSdk = 36
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
}

dependencies {
    // Librería Picasso para carga de imágenes
    implementation("com.squareup.picasso:picasso:2.5.2")

    // Librería CircleImageView para imágenes circulares
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Dependencias base de AndroidX y Material Design
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.activity.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
