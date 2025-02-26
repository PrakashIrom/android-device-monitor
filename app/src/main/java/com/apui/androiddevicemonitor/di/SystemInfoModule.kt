package com.apui.androiddevicemonitor.di

import android.app.ActivityManager
import android.app.usage.UsageStatsManager
import android.content.Context
import com.apui.androiddevicemonitor.data.repository.performancerepo.QueryEventsRepoImpl
import com.apui.androiddevicemonitor.data.repository.performancerepo.RamUsageRepoImpl
import com.apui.androiddevicemonitor.data.repository.performancerepo.RunningServicesRepoImpl
import com.apui.androiddevicemonitor.domain.repository.performancerepo.QueryEventsRepo
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RamUsageRepo
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RunningServicesRepo
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetQueryEventsUseCase
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetRamInfoUseCase
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetRunningServicesUseCase
import com.apui.androiddevicemonitor.ui.viewModel.QueryEventsViewModel
import com.apui.androiddevicemonitor.ui.viewModel.RamInfoViewModel
import com.apui.androiddevicemonitor.ui.viewModel.RunningServicesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val systemInfoModule =
    module {
        single {
            androidContext().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        }
        single<RamUsageRepo> {
            RamUsageRepoImpl(get())
        }
        factory {
            GetRamInfoUseCase(get())
        }
        single<RunningServicesRepo> {
            RunningServicesRepoImpl(get())
        }
        factory {
            GetRunningServicesUseCase(get())
        }
        viewModel {
            RamInfoViewModel(get())
        }
        viewModel {
            RunningServicesViewModel(get())
        }

        single {
            androidContext().getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        }
        single<QueryEventsRepo> {
            QueryEventsRepoImpl(get())
        }
        single {
            GetQueryEventsUseCase(get(), androidContext())
        }
        viewModel {
            QueryEventsViewModel(get())
        }
    }
