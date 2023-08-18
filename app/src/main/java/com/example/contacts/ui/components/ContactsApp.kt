package com.example.contacts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.contacts.R
import com.example.contacts.UsersUIState
import com.example.contacts.models.User

@Composable
fun ContactsApp(uiState: UsersUIState) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        UsersGroups(uiState)
    }
}

@Composable
fun AvantsoftHeader() {
    Box(
        modifier = Modifier
            .height(87.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.Center

    ) {
        AvantsoftLogo()
    }
}


@Composable
private fun AvantsoftLogo() {
    Image(
        modifier = Modifier
            .height(31.dp),

        painter = painterResource(id = R.drawable.avantsoft_logo),
        contentDescription = stringResource(
            id = R.string.avantsoft_logo
        )
    )
}

@Composable
private fun UsersGroups(uiState: UsersUIState) {
    val users = uiState.users

    val maxElementsByGroup = 10
    val groups = mutableListOf<List<User>>()

    (users.indices step maxElementsByGroup).forEach { index ->
        val group = users.subList(index, (index + maxElementsByGroup).coerceAtMost(users.size))
        groups.add(group)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item { AvantsoftHeader() }
        items(groups) { group ->
            UsersGroup(group)
        }
    }
}


@Composable
fun UsersGroup(users: List<User>) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(users) { user ->
            UserCard(user)
        }
    }
}