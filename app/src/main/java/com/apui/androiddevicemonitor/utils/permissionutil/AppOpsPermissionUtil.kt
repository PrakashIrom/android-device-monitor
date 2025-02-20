package com.apui.androiddevicemonitor.utils.permissionutil

import android.app.AppOpsManager
import android.content.Context
import android.content.Intent

object AppOpsPermissionUtil {
    fun isAppOpsPermissionGranted(
        context: Context,
        appOpsPermission: String,
    ): Boolean {
        val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode =
            appOps.unsafeCheckOpNoThrow(
                appOpsPermission,
                android.os.Process.myUid(),
                context.packageName,
            )

        return mode == AppOpsManager.MODE_ALLOWED
    }

    fun showAppOpsSetting(
        context: Context,
        settingAction: String,
    ) {
        val intent = Intent(settingAction)
        context.startActivity(intent)
    }
}
