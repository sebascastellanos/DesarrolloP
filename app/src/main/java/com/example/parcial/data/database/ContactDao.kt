package com.example.parcial.data.database

import com.example.parcial.domain.model.Contact
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ContactDao {
    @Insert
    suspend fun insert(contact: Contact)
    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>
}