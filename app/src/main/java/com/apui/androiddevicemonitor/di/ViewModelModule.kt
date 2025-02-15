package com.apui.androiddevicemonitor.di

import com.apui.androiddevicemonitor.ui.viewModel.BatteryInfoViewModel
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import org.koin.dsl.module

val topBarViewModelModule = module {
    single<TopBarViewModel> {
        TopBarViewModel()
    }
}

val batteryInfoViewModel = module {
    single<BatteryInfoViewModel> {
        BatteryInfoViewModel(get())
    }
}
