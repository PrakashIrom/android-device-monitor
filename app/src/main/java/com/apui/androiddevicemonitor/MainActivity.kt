package com.apui.androiddevicemonitor

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.apui.androiddevicemonitor.receivers.BatteryReceiver
import com.apui.androiddevicemonitor.ui.navigation.AppNavHost
import com.apui.androiddevicemonitor.ui.theme.AndroidDeviceMonitorTheme
import com.apui.androiddevicemonitor.utils.TopBar

class MainActivity : ComponentActivity() {

    private lateinit var batteryReceiver: BatteryReceiver

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val batteryLevel = mutableIntStateOf(0)
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        batteryReceiver = BatteryReceiver { value ->
            batteryLevel.intValue = value.percentage
            //Log.d("BatteryLevelReceiver", "Battery level: ${batteryLevel.intValue}%")
        }
        registerReceiver(batteryReceiver, intentFilter)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AndroidDeviceMonitorTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar(navController = navController)
                    }
                ) { paddingValues ->

                    AppNavHost(
                        paddingValues = paddingValues,
                        navController = navController
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(batteryReceiver)
    }
}
