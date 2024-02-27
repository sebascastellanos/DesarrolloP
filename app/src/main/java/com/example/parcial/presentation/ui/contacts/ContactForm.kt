package com.example.parcial.presentation.ui.contacts

import com.example.parcial.domain.model.Contact
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier

@Composable
fun ContactForm(onSaveContact: (Contact) -> Unit){
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding()){
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") }
        )
        TextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            label = { Text("Email Address") }
        )
        Button(onClick = { onSaveContact(Contact(name = name, phoneNumber = phoneNumber, emailAddress = emailAddress)) }) {
            Text("Save ")
        }


    }
}