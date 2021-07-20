package com.example.chunggo803


import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//스프링에서 handlerMapping을 하듯이 여기다가 등록해두는 거임.
val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { MyPageViewModel() }
    viewModel { ChatListViewModel() }

    //single { SampleRepository() }
    //single { SampleController() }
}