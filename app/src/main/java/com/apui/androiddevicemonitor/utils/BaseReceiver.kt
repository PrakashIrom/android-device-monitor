package com.apui.androiddevicemonitor.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

abstract class BaseReceiver : BroadcastReceiver() {

    abstract fun onEventReceived(context: Context?, intent: Intent?)

    override fun onReceive(context: Context?, intent: Intent?) {
        onEventReceived(context, intent)
    }

}