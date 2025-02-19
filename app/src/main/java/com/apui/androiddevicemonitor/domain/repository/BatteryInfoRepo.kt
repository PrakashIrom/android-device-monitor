package com.apui.androiddevicemonitor.domain.repository

import android.content.Intent
import com.apui.androiddevicemonitor.data.models.BatteryInfo

interface BatteryInfoRepo {
    fun getBatteryInfo(intent: Intent?): BatteryInfo
}
