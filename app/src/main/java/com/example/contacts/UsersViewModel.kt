package com.example.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.models.User
import com.example.contacts.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UsersViewModel(val apiService: ApiService) : ViewModel() {
    private val _uiState = MutableStateFlow(UsersUIState(loading = true))
    val uiState: StateFlow<UsersUIState> = _uiState

    init {
        viewModelScope.launch {
            initEmailList()
        }
    }

    private suspend fun initEmailList() {
        val usersContainer = apiService.getUsers()
        usersContainer.body()!!.run {

            _uiState.value = UsersUIState(
                users = asDomainModel()
            )
        }
    }
}

data class UsersUIState(
    val users: List<User> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
