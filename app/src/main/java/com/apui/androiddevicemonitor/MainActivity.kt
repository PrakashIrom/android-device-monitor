package com.apui.androiddevicemonitor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
                            isBackButtonVisible = false
                        )
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        /*when (screen.value) {
                            Screens.MAIN -> {}
                            Screens.SENSOR -> {}
                            Screens.BATTERY -> {}
                            Screens.NETWORK -> {}
                            Screens.PROCESSING -> {}
                        }*/
                    }
                }
            }
        }
    }
}
