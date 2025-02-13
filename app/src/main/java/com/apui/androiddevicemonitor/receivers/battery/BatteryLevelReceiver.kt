package com.apui.androiddevicemonitor.receivers.battery

import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import com.apui.androiddevicemonitor.utils.BaseReceiver

class BatteryLevelReceiver : BaseReceiver() {
    override fun onEventReceived(context: Context?, intent: Intent?) {
        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: 0
        val scale = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: 0

        if (level != -1 && scale != -1) {
            val batteryPercentage = (level.times(100)) / scale
        }
    }
}