package com.apui.androiddevicemonitor.ui.cards

import android.app.AppOpsManager
import android.provider.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.ui.viewModel.AppOpsPermissionViewModel
import com.apui.androiddevicemonitor.utils.CustomBottomSheet
import com.apui.androiddevicemonitor.utils.CustomCard
import com.apui.androiddevicemonitor.utils.permissionutil.AppOpsPermissionState
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProcessingCard(
    navController: NavHostController,
    viewModel: AppOpsPermissionViewModel = koinViewModel(),
) {
    val permissionState by viewModel.appOpsPermissionState.collectAsState()
    val context = LocalContext.current
    val lifeCycleOwner = LocalLifecycleOwner.current
    val showBottomSheet = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

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
            showBottomSheet.value = true
            if (permissionState == AppOpsPermissionState.GRANTED) {
                navController.navigate("processing")
            }
        },
    )

    if (showBottomSheet.value && permissionState != AppOpsPermissionState.GRANTED) {
        CustomBottomSheet(
            onDismissRequest = { showBottomSheet.value = false },
            sheetState = sheetState,
            title = "Usage Data Access Permission",
            contentText = "You need to allow permission for Usage Data Access to get the usage information.",
        ) {
            viewModel.checkAppOpsPermission(
                context,
                AppOpsManager.OPSTR_GET_USAGE_STATS,
                Settings.ACTION_USAGE_ACCESS_SETTINGS,
            )
        }
    }
}
