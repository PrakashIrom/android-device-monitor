package com.apui.androiddevicemonitor.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.convertDate(): String {
    val date = Date(this)
    val format = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
    return format.format(date)
}
