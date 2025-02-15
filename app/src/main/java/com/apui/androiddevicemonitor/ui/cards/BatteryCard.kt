package com.apui.androiddevicemonitor.ui.cards

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.utils.CustomCard

@Composable
fun BatteryCard(navController: NavHostController) {
    CustomCard(
        titleId = R.string.Battery, iconRes = R.drawable.battery,
        onClick = {
            navController.navigate("battery")
        },
    )
}