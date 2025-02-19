package com.apui.androiddevicemonitor.utils

import com.apui.androiddevicemonitor.R

enum class Screens(
    val title: Int,
    val iconRes: Int,
) {
    HOME(R.string.app_name, R.drawable.icons8health75),
    SENSOR(R.string.Sensor, R.drawable.sensor),
    BATTERY(R.string.Battery, R.drawable.battery),
    NETWORK(R.string.Network, R.drawable.mobile_network),
    PROCESSING(R.string.Processing, R.drawable.process),
}
