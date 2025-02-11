package com.apui.androiddevicemonitor.utils

import com.apui.androiddevicemonitor.R

enum class Screens(val title: Int, val iconRes: Int) {
    HOME(R.string.app_name, R.drawable.icons8health75),
    SENSOR(R.string.Sensor, R.drawable.icons8health75),
    BATTERY(R.string.Battery, R.drawable.icons8health75),
    NETWORK(R.string.Network, R.drawable.icons8health75),
    PROCESSING(R.string.Processing, R.drawable.icons8health75)
}
