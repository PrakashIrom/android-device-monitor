package com.apui.androiddevicemonitor.ui.cards

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.utils.CustomCard

@Composable
fun SensorCard(navController: NavHostController) {
    CustomCard(
        titleId = R.string.Sensor,
        iconRes = R.drawable.sensor,
        onClick = { navController.navigate("sensor") },
    )
}
