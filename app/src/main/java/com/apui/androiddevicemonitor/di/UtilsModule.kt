package com.apui.androiddevicemonitor.di

import com.apui.androiddevicemonitor.ui.viewModel.AppOpsPermissionViewModel
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import org.koin.dsl.module

val topBarViewModelModule =
    module {
        single<TopBarViewModel> {
            TopBarViewModel()
        }
    }

val appOpsPermissionViewModelModule =
    module {
        single<AppOpsPermissionViewModel> {
            AppOpsPermissionViewModel()
        }
    }
