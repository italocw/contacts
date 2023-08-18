package com.example.contacts.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET
import java.net.InetAddress

const val USERS_ENDPOINT = "ce47ee53-6531-4821-a6f6-71a188eaaee0"

interface ApiService {

    @GET(USERS_ENDPOINT)
    suspend fun getUsers(): Response<NetworkUsersContainer>
}

suspend fun isInternetAvailable(): Boolean {
    return withContext(Dispatchers.IO) {
        try {
            val ipAddr: InetAddress = InetAddress.getByName("google.com")
            !ipAddr.equals("")
        } catch (e: Exception) {
            false
        }
    }
}