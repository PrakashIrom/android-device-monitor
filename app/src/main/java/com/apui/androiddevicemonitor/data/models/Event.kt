package com.apui.androiddevicemonitor.data.models

data class Event(
    val packageName: String,
    val eventType: Int,
    val timeStamp: Long,
)
