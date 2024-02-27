package com.example.parcial.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial.data.repository.ContactRepository
import com.example.parcial.domain.model.Contact
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel() {
    val allContacts: LiveData<List<Contact>> = repository.allContacts

    fun insertContact(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }
}

