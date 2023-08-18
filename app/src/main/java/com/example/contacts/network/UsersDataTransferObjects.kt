package com.example.contacts.network

import com.example.contacts.models.User
import com.google.gson.annotations.SerializedName

data class NetworkUsersContainer(
    @SerializedName("users")
    val networkUsers: List<NetworkUser>
) {
    data class NetworkUser(
        val id: Int,
        val name: String,
        val age: Int,
        val email: String
    )

    fun NetworkUsersContainer.asDomainModel(): List<User> {

        return networkUsers.map {
            User(
                id = it.id.toString(),
                name = it.name,
                age = it.age,
                email = it.email
            )
        }
    }
}

