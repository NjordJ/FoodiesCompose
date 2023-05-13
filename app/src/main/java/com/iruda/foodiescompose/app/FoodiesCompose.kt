package com.iruda.foodiescompose.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import com.iruda.foodiescompose.di.appModule
import com.iruda.foodiescompose.di.dataModule
import com.iruda.foodiescompose.di.domainModule

class FoodiesCompose: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@FoodiesCompose)
            modules(
                listOf(
                    appModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }
}