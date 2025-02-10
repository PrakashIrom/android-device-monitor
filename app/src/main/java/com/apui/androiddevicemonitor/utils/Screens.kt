package com.apui.androiddevicemonitor.utils

import com.apui.androiddevicemonitor.R

enum class Screens(val title: String, val iconRes: Int) {
    HOME(R.string.app_name.toString(), R.drawable.icons8health75),
    SENSOR(R.string.Sensor.toString(), R.drawable.icons8health75),
    BATTERY(R.string.Battery.toString(), R.drawable.icons8health75),
    NETWORK(R.string.Network.toString(), R.drawable.icons8health75),
    PROCESSING(R.string.Processing.toString(), R.drawable.icons8health75)
}
