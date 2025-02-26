package com.apui.androiddevicemonitor.domain.model

data class QueryEvent(
    val appName: String,
    val eventType: String,
    val timeStamp: String,
)
