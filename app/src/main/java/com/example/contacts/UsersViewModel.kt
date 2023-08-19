package com.example.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel(val repository: Repository) : ViewModel() {
    private val _uiState = MutableStateFlow(UsersUIState(loading = true))
    val uiState: StateFlow<UsersUIState> = _uiState

    init {
        viewModelScope.launch {
            initUsersList()
        }
    }

    private suspend fun initUsersList() {
        _uiState.value = UsersUIState(
            users = repository.getUsersFromInternet()
        )
    }
}

data class UsersUIState(
    val users: List<User> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
