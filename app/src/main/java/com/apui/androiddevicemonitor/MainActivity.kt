package com.apui.androiddevicemonitor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.apui.androiddevicemonitor.ui.navigation.AppNavHost
import com.apui.androiddevicemonitor.ui.screens.HomeScreen
import com.apui.androiddevicemonitor.ui.theme.AndroidDeviceMonitorTheme
import com.apui.androiddevicemonitor.utils.Screens
import com.apui.androiddevicemonitor.utils.TopBar

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screen = mutableStateOf(Screens.HOME)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AndroidDeviceMonitorTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar(
                            screen = screen.value,
                            isBackButtonVisible = true
                        )
                    }
                ) { paddingValues ->
                    val navController = rememberNavController()
                    AppNavHost(paddingValues=paddingValues, navController = navController)
                }
            }
        }
    }
}
