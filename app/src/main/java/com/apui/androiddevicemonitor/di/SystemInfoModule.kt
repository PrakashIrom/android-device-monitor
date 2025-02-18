package com.apui.androiddevicemonitor.di

import android.app.ActivityManager
import android.content.Context
import com.apui.androiddevicemonitor.data.repository.performancerepo.RamUsageRepoImpl
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RamUsageRepo
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetRamInfoUseCase
import com.apui.androiddevicemonitor.ui.viewModel.RamInfoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val systemInfoModule = module {
    single {
        androidContext().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    }
    single<RamUsageRepo> {
        RamUsageRepoImpl(get())
    }
    factory {
        GetRamInfoUseCase(get())
    }
    viewModel{
        RamInfoViewModel(get())
    }
}