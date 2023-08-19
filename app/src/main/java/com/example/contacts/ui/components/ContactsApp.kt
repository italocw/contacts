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
import androidx.compose.ui.res.dimensionResource
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
        val usersGroups = uiState.users.chunked(10)

        UsersGroups(usersGroups)
    }
}

@Composable
fun AvantsoftHeader() {
    val mediumPadding =  dimensionResource(id = R.dimen.medium_padding)

    Box(
        modifier = Modifier
            .height(87.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(bottomEnd = mediumPadding, bottomStart =mediumPadding)
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
private fun UsersGroups(usersGroups: List<List<User>>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy( dimensionResource(id = R.dimen.large_padding)),
        contentPadding = PaddingValues(bottom = dimensionResource(id = R.dimen.medium_padding))
    ) {
        item { AvantsoftHeader() }

        items(usersGroups) { group ->
            UsersGroup(group)
        }
    }
}


@Composable
fun UsersGroup(users: List<User>) {
    val mediumPadding =  dimensionResource(id = R.dimen.medium_padding)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(mediumPadding),
        contentPadding = PaddingValues(horizontal = mediumPadding)
    ) {
        items(users) { user ->
            UserCard(user)
        }
    }
}