package com.apui.androiddevicemonitor.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apui.androiddevicemonitor.ui.screens.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues){
    NavHost(navController = navController, startDestination = NavRoutes.Home.route){
        composable(NavRoutes.Home.route){
            HomeScreen(paddingValues)
        }
        composable(NavRoutes.Sensor.route){

        }
        composable(NavRoutes.Battery.route){

        }
        composable(NavRoutes.Processing.route){

        }
        composable(NavRoutes.Network.route){

        }
    }
}