package com.apui.androiddevicemonitor.domain.repository.performancerepo

import com.apui.androiddevicemonitor.data.models.MemoryInfo

interface RamUsageRepo {
    fun getRamUsageInfo(): MemoryInfo
}