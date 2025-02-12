package com.apui.androiddevicemonitor.ui.cards

import androidx.compose.runtime.Composable
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.utils.CustomCard

@Composable
fun SensorCard(){
    CustomCard(titleId = R.string.Sensor, iconRes = R.drawable.sensor)
}