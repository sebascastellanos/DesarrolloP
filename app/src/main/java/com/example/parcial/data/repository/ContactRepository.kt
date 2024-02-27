package com.example.parcial.data.repository

import androidx.lifecycle.LiveData
import com.example.parcial.data.database.ContactDao
import com.example.parcial.domain.model.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {


    // Obtener todos los contactos
    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()

    // Agregar un nuevo contacto
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }


}