package com.apui.androiddevicemonitor.data.models

data class RunningServices(
    val processName: String,
    val pid: Int,
    val importance: Int,
)
