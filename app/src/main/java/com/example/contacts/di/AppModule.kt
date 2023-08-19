package com.example.contacts.di

import com.example.contacts.Constants
import com.example.contacts.Repository
import com.example.contacts.UsersViewModel
import com.example.contacts.network.UsersRemoteDataSource
import com.example.contacts.network.UsersService
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    viewModelOf(::UsersViewModel)

    single { provideRetrofit() }
    single { provideApiService(get()) }
    single { UsersRemoteDataSource(get()) }
    single { provideRepository(get()) }
}

private fun provideRepository(remoteDataSource: UsersRemoteDataSource) = Repository.getRepository(remoteDataSource)

private fun provideRetrofit(): Retrofit {
    val gson = GsonBuilder().create()

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(Constants.API_REQUEST_URL)
        .build()
}

private fun provideApiService(retrofit: Retrofit): UsersService =
    retrofit.create(UsersService::class.java)


