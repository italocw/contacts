package com.example.contacts.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contacts.R
import com.example.contacts.models.User
import com.example.contacts.ui.theme.AvantsoftLogoBackground
import com.example.contacts.ui.theme.CardGradientFirst
import com.example.contacts.ui.theme.CardGradientSecond
import com.example.contacts.ui.theme.CardGradientThird
import com.example.contacts.ui.theme.ContactsTheme

@Composable
fun UserCard(user: User) {
    val mediumPadding = dimensionResource(id = R.dimen.medium_padding)
    val smallPadding = dimensionResource(id = R.dimen.small_padding)
    val extraSmallPadding = dimensionResource(R.dimen.extra_small_padding)

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            CardGradientFirst, CardGradientSecond, CardGradientThird
        )
    )

    OutlinedCard(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .size(width = 239.dp, height = 185.dp)
            .shadow(8.dp),
        border = BorderStroke(2.dp, gradientBrush)
    ) {
        Column(
            Modifier.padding(mediumPadding)
        ) {
            Name(user.name)
            Divider()
            UserField(stringResource(id = R.string.email), user.email)

            Row(
                Modifier.padding(top = smallPadding)
            ) {

                Column() {
                    UserField(stringResource(id = R.string.age), user.age.toString())
                }

                Spacer(
                    Modifier.width(extraSmallPadding)
                )
                Column() {
                    UserField(stringResource(id = R.string.id), user.id)
                }
            }
        }
    }
}

@Composable
private fun UserField(title: String, data: String) {
    UserFieldTitle(title)
    UserFieldData(data)
}

@Composable
private fun Divider() {
    val extraSmallPadding = dimensionResource(R.dimen.extra_small_padding)

    Spacer(
        modifier = Modifier
            .padding(vertical = extraSmallPadding)
            .fillMaxWidth()
            .height(2.dp)
            .background(AvantsoftLogoBackground)
    )
}

@Composable
private fun Name(name: String) {
    Text(
        name,
        style = MaterialTheme.typography.titleLarge,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun UserFieldData(data: String) {
    Text(
        text = data,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.alpha(0.8f),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
private fun UserFieldTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, name = "DefaultPreviewLight"
)

@Composable
fun ContactsAppPreview() {
    ContactsTheme {
        val user = User(name = "John Doe", email = "johndoe@example.com", age = 25, id = "1")
        UserCard(user)
    }
}