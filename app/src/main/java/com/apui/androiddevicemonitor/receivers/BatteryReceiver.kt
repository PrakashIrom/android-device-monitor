package com.apui.androiddevicemonitor.receivers

import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import com.apui.androiddevicemonitor.data.models.BatteryInfo
import com.apui.androiddevicemonitor.utils.BaseReceiver
import com.apui.androiddevicemonitor.utils.battery.toChargingStatusString
import com.apui.androiddevicemonitor.utils.battery.toHealthString
import com.apui.androiddevicemonitor.utils.battery.toPluggedSourceString

class BatteryReceiver(private val giveValue: (BatteryInfo) -> Unit) : BaseReceiver() {

    override fun onEventReceived(context: Context?, intent: Intent?) {

        intent ?: return

        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val health =
            intent.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN)
        val voltage = (intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -0).div(1000.0))
        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        val plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
        val temperature =
            intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1).div(10.0)
        val batteryPercentage = if (scale > 0) (level * 100) / scale else 0
        val batteryInfo = BatteryInfo(
            percentage = batteryPercentage,
            health = health.toHealthString(),
            voltage = voltage,
            status = status.toChargingStatusString(),
            plugged = plugged.toPluggedSourceString(),
            temperature = temperature
        )

        giveValue(batteryInfo)
    }

}