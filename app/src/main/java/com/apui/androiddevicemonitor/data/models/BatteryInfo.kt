package com.apui.androiddevicemonitor.data.models

data class BatteryInfo(
    val percentage: Int,
    val health: String,
    val voltage: Double,
    val status: String,
    val plugged: String,
    val temperature: Double,
)
