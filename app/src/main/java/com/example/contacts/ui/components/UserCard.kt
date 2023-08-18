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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
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

        val gradientBrush = Brush.horizontalGradient(
            colors = listOf(
                CardGradientFirst,
                CardGradientSecond,
                CardGradientThird
            )
        )

        OutlinedCard(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .size(width = 239.dp, height = 185.dp).shadow(8.dp), border = BorderStroke(2.dp, gradientBrush)

        ) {
            Column(
                Modifier.padding(16.dp)

            ) {
                Text(
                    user.name,
                    style = MaterialTheme.typography.titleLarge,  maxLines = 1, overflow = TextOverflow.Ellipsis
                )

                Spacer(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(AvantsoftLogoBackground)
                )

                UserFieldTitle(stringResource(id = R.string.email))
                UserFieldData(user.email)

                Row(
                    Modifier
                        .wrapContentHeight()
                        .padding(top = 8.dp)
                ) {

                    Column() {
                        UserFieldTitle(stringResource(id = R.string.age))
                        UserFieldData(user.age.toString())

                    }
                    Column(Modifier.padding(start = 4.dp)) {
                        UserFieldTitle(stringResource(id = R.string.id))
                        UserFieldData(user.id)
                    }
                }
            }
    }
}

@Composable
private fun UserFieldData(data: String) {
    Text(text = data, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.alpha(0.8f), maxLines = 1,  overflow = TextOverflow.Ellipsis)   }


@Composable
private fun UserFieldTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall,
         maxLines = 1,  overflow = TextOverflow.Ellipsis
    )
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun ContactsAppPreview() {
    ContactsTheme {
        val user = User(name = "John Doe", email = "johndoe@example.com", age = 25, id = "1")
        UserCard(user)
    }
}