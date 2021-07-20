package com.example.chunggo803

import android.app.Application
import org.koin.core.context.startKoin

class Chunggo802Application : Application() {
    override fun onCreate(){
        super.onCreate()

        startKoin{
            modules(appModule)
        }
    }


}
