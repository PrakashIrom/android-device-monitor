package com.apui.androiddevicemonitor.utils.battery

import android.os.BatteryManager

fun Int.toHealthString(): String {
    return when (this) {
        BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
        BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
        BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
        BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
        BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Failure"
        else -> "Unknown"
    }
}

fun Int.toChargingStatusString(): String {
    return when (this) {
        BatteryManager.BATTERY_STATUS_CHARGING -> "Charging"
        BatteryManager.BATTERY_STATUS_FULL -> "Full"
        BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "Not Charging"
        BatteryManager.BATTERY_STATUS_DISCHARGING -> "Discharging"
        else -> "Unknown"
    }
}

fun Int.toPluggedSourceString(): String {
    return when (this) {
        BatteryManager.BATTERY_PLUGGED_AC -> "AC Charger"
        BatteryManager.BATTERY_PLUGGED_USB -> "USB Charger"
        BatteryManager.BATTERY_PLUGGED_WIRELESS -> "Wireless Charger"
        else -> "Not Plugged"
    }
}