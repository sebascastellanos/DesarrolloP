package com.example.parcial.presentation.ui.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial.domain.model.Contact
import com.example.parcial.presentation.viewmodel.ContactViewModel

@Composable
fun ContactListScreen(contactViewModel: ContactViewModel = viewModel()) {
    val contacts = contactViewModel.allContacts.observeAsState(listOf())

    Column {
        LazyColumn {
            items(contacts.value) { contact ->
                ContactItem(contact)
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Text(text = "${contact.name} - ${contact.phoneNumber}")
}