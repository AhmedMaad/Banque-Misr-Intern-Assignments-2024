package com.maad.contactsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.maad.contactsapp.data.DataSource
import com.maad.contactsapp.model.Contact
import com.maad.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { ContactsAppTheme { AppBar() } }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.contacts_app)) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = stringResource(R.string.call_home)
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) { ContactsList(contacts = DataSource().getContacts()) }
    }
}

@Composable
fun ContactsList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
    ) {
        items(contacts) { photo -> ContactListItem(photo, modifier) }
    }
}

@Composable
fun ContactListItem(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        shape = RectangleShape,
        modifier = modifier
            .clickable {
                val i = Intent(Intent.ACTION_DIAL, "tel:${contact.phoneNumber}".toUri())
                context.startActivity(i)
            }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = contact.pic),
                contentDescription = stringResource(id = contact.name),
            )
            Text(
                text = stringResource(id = contact.name),
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            SelectionContainer {
                Text(
                    text = contact.phoneNumber,
                    fontSize = 12.sp
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ContactsList(contacts = DataSource().getContacts())
}