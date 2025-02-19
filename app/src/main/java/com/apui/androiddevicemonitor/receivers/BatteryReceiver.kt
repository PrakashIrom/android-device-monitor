package com.apui.androiddevicemonitor.receivers

import android.content.Intent
import com.apui.androiddevicemonitor.utils.BaseReceiver

class BatteryReceiver(
    private val onBatteryUpdate: (Intent) -> Unit,
) : BaseReceiver() {
    override fun onEventReceived(intent: Intent?) {
        intent?.let {
            onBatteryUpdate(it)
        }
    }
}
