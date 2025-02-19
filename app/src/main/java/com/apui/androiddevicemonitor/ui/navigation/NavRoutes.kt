package com.apui.androiddevicemonitor.ui.navigation

sealed class NavRoutes(
    val route: String,
) {
    object Home : NavRoutes("home")

    object Sensor : NavRoutes("sensor")

    object Battery : NavRoutes("battery")

    object Network : NavRoutes("network")

    object Processing : NavRoutes("processing")
}
