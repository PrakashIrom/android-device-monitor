package com.apui.androiddevicemonitor.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apui.androiddevicemonitor.ui.screens.HomeScreen
import com.apui.androiddevicemonitor.ui.screens.battery.BatteryScreen
import com.apui.androiddevicemonitor.ui.screens.network.NetworkScreen
import com.apui.androiddevicemonitor.ui.screens.processing.ProcessingScreen
import com.apui.androiddevicemonitor.ui.screens.sensor.SensorScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    // To handle Android Back button/swipe to go back to the previous screen
    BackHandler(enabled = navController.previousBackStackEntry != null) {
        navController.navigateUp()
    }

    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(NavRoutes.Home.route) {
            HomeScreen(paddingValues, navController)
        }
        composable(NavRoutes.Sensor.route) {
            SensorScreen()
        }
        composable(NavRoutes.Battery.route) {
            BatteryScreen()
        }
        composable(NavRoutes.Processing.route) {
            ProcessingScreen()
        }
        composable(NavRoutes.Network.route) {
            NetworkScreen()
        }
    }
}
