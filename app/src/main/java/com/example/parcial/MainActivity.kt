package com.example.parcial


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.parcial.data.database.AppDatabase
import com.example.parcial.presentation.ui.contacts.ContactForm
import com.example.parcial.presentation.ui.contacts.ContactListScreen
import com.example.parcial.presentation.ui.theme.ParcialTheme
import com.example.parcial.presentation.viewmodel.ContactViewModel


class MainActivity : ComponentActivity() {

    private val contactViewModel: ContactViewModel by viewModels()
    val database by lazy { AppDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParcialTheme {
                // Estado para controlar la visibilidad
                val showContactList = remember { mutableStateOf(false) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        if (!showContactList.value) {
                            // Muestra el formulario y un botón para ver la lista de contactos
                            ContactForm(onSaveContact = { contact ->
                                contactViewModel.insertContact(contact)
                            })
                            Button(onClick = { showContactList.value = true }) {
                                Text("Ver contactos guardados")
                            }
                        } else {
                            // Muestra la lista de contactos y un botón para agregar nuevos
                            ContactListScreen(contactViewModel = contactViewModel)
                            Button(onClick = { showContactList.value = false }) {
                                Text("Agregar nuevo contacto")
                            }
                        }
                    }
                }
            }
        }
    }
}