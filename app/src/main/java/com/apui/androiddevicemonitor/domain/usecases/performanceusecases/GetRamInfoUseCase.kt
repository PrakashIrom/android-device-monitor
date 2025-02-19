package com.apui.androiddevicemonitor.domain.usecases.performanceusecases

import com.apui.androiddevicemonitor.domain.model.RamUsageInfo
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RamUsageRepo
import java.util.Locale

class GetRamInfoUseCase(
    private val ramUsageRepo: RamUsageRepo,
) {
    operator fun invoke(): RamUsageInfo {
        val ramInfo = ramUsageRepo.getRamUsageInfo()
        val usageLimit = ramInfo.totalMemory - ramInfo.availableMemory

        return RamUsageInfo(
            totalMemory = formattedSize(ramInfo.totalMemory),
            availableMemory = formattedSize(ramInfo.availableMemory),
            usedMemory = formattedSize(usageLimit),
        )
    }

    private fun formattedSize(bytes: Long): String {
        val kb = bytes / 1024.0
        val mb = kb / 1024.0
        val gb = mb / 1024.0

        return when {
            gb >= 1 -> String.format(Locale.US, "%.2f GB", gb)
            mb >= 1 -> String.format(Locale.US, "%.2f MB", mb)
            else -> String.format(Locale.US, "%.2f KB", kb)
        }
    }
}
