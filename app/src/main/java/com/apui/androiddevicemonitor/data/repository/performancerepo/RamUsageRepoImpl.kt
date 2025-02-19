package com.apui.androiddevicemonitor.data.repository.performancerepo

import android.app.ActivityManager
import com.apui.androiddevicemonitor.data.models.MemoryInfo
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RamUsageRepo

class RamUsageRepoImpl(
    private val activityManager: ActivityManager,
) : RamUsageRepo {
    override fun getRamUsageInfo(): MemoryInfo {
        val memoryInfo = ActivityManager.MemoryInfo()
        activityManager.getMemoryInfo(memoryInfo)

        return MemoryInfo(
            totalMemory = memoryInfo.totalMem,
            availableMemory = memoryInfo.availMem,
        )
    }
}
