package com.apui.androiddevicemonitor.domain.model

data class RamUsageInfo(
    val totalMemory: String,
    val availableMemory: String,
    val usedMemory: String,
)
