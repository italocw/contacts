package com.example.contacts

import com.example.contacts.network.UsersRemoteDataSource

class Repository private constructor(private val remoteDataSource: UsersRemoteDataSource) {
    suspend fun getUsersFromInternet() = remoteDataSource.getUsers()

    companion object {
        private var INSTANCE: Repository? = null

        fun getRepository(
            remoteDataSource: UsersRemoteDataSource
        ): Repository {
            return INSTANCE ?: Repository(remoteDataSource).also {
                INSTANCE = it
            }
        }
    }
}