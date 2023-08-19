package com.example.contacts.network

import com.example.contacts.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersRemoteDataSource(private val usersService: UsersService) {

    suspend fun getUsers():List<User>
    {
        return withContext(Dispatchers.IO) {
            val usersContainer = usersService.getUsers()
            usersContainer.body()!!.run {
                asDomainModel()
            }
        }
    }
}