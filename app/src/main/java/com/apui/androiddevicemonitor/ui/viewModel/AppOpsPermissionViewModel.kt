package com.apui.androiddevicemonitor.ui.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.apui.androiddevicemonitor.utils.permissionutil.AppOpsPermissionUtil
import com.apui.androiddevicemonitor.utils.permissionutil.PermissionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppOpsPermissionViewModel : ViewModel() {
    private val _appOpsPermissionState = MutableStateFlow(PermissionState.REQUIRED)
    val appOpsPermissionState: StateFlow<PermissionState> = _appOpsPermissionState

    fun checkAppOpsPermission(
        context: Context,
        appOpsPermission: String,
        settingAction: String,
    ) {
        if (AppOpsPermissionUtil.isAppOpsPermissionGranted(context, appOpsPermission)) {
            _appOpsPermissionState.value = PermissionState.GRANTED
        } else {
            AppOpsPermissionUtil.showAppOpsSetting(context, settingAction)
            _appOpsPermissionState.value = PermissionState.REQUIRED
        }
    }

    fun refreshPermissionState(
        context: Context,
        appOpsPermission: String,
    ) {
        _appOpsPermissionState.value =
            if (AppOpsPermissionUtil.isAppOpsPermissionGranted(context, appOpsPermission)) {
                PermissionState.GRANTED
            } else {
                PermissionState.DENIED
            }
    }
}
