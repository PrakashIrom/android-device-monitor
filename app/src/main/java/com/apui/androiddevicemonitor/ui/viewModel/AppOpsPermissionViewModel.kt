package com.apui.androiddevicemonitor.ui.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.apui.androiddevicemonitor.utils.permissionutil.AppOpsPermissionState
import com.apui.androiddevicemonitor.utils.permissionutil.AppOpsPermissionUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppOpsPermissionViewModel : ViewModel() {
    private val _appOpsPermissionState = MutableStateFlow(AppOpsPermissionState.REQUIRED)
    val appOpsPermissionState: StateFlow<AppOpsPermissionState> = _appOpsPermissionState

    fun checkAppOpsPermission(
        context: Context,
        appOpsPermission: String,
        settingAction: String,
    ) {
        if (AppOpsPermissionUtil.isAppOpsPermissionGranted(context, appOpsPermission)) {
            _appOpsPermissionState.value = AppOpsPermissionState.GRANTED
        } else {
            AppOpsPermissionUtil.showAppOpsSetting(context, settingAction)
            _appOpsPermissionState.value = AppOpsPermissionState.REQUIRED
        }
    }

    // this function is used to refresh the permission state after the user returns from app setting screen
    fun refreshPermissionState(
        context: Context,
        appOpsPermission: String,
    ) {
        _appOpsPermissionState.value =
            if (AppOpsPermissionUtil.isAppOpsPermissionGranted(context, appOpsPermission)) {
                AppOpsPermissionState.GRANTED
            } else {
                AppOpsPermissionState.DENIED
            }
    }
}
