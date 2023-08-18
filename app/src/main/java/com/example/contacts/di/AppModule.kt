package com.example.contacts.di

import com.example.contacts.Constants
import com.example.contacts.UsersViewModel
import com.example.contacts.network.ApiService
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    viewModelOf(::UsersViewModel)

    single { provideRetrofit() }
    single { provideApiService(get()) }



  }



private fun provideRetrofit(): Retrofit {
    val gson = GsonBuilder().create()

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(Constants.API_REQUEST_URL)
        .build()
}

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)


