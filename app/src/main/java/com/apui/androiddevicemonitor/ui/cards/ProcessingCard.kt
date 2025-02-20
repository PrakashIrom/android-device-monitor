package com.apui.androiddevicemonitor.ui.cards

import android.app.AppOpsManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.ui.viewModel.AppOpsPermissionViewModel
import com.apui.androiddevicemonitor.utils.CustomCard
import com.apui.androiddevicemonitor.utils.permissionutil.PermissionState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProcessingCard(
    navController: NavHostController,
    viewModel: AppOpsPermissionViewModel = koinViewModel(),
) {
    val permissionState by viewModel.appOpsPermissionState.collectAsState()
    val context = LocalContext.current
    val lifeCycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current

    DisposableEffect(lifeCycleOwner) {
        val observer =
            LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_RESUME) {
                    viewModel.refreshPermissionState(context, AppOpsManager.OPSTR_GET_USAGE_STATS)
                }
            }
        lifeCycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifeCycleOwner.lifecycle.removeObserver(observer)
        }
    }

    CustomCard(
        titleId = R.string.Processing,
        iconRes = R.drawable.process,
        onClick = {
            viewModel.checkAppOpsPermission(
                context,
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.provider.Settings.ACTION_USAGE_ACCESS_SETTINGS,
            )
            if (permissionState == PermissionState.GRANTED) {
                navController.navigate("processing")
            }
        },
    )
}
