package com.apui.androiddevicemonitor.di

import android.app.Application
import com.apui.androiddevicemonitor.data.repository.BatteryInfoRepoImpl
import com.apui.androiddevicemonitor.domain.repository.BatteryInfoRepo
import com.apui.androiddevicemonitor.domain.usecases.batteryusecases.GetBatteryInfoUseCase
import com.apui.androiddevicemonitor.ui.viewModel.BatteryInfoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val batteryInfoModule = module {
    single<BatteryInfoRepo> {
        BatteryInfoRepoImpl()
    }
    single {
        androidApplication()
    }
    factory {
        GetBatteryInfoUseCase(get())
    }
    viewModel { (application: Application) ->
        BatteryInfoViewModel(application, get())
    }
}