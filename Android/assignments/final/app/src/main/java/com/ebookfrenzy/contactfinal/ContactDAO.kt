package com.ebookfrenzy.contactfinal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String) : List<Contact>

    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContact(id: Int) //need to connect trashcan image to delete

    @Query("SELECT * FROM contacts")
    fun getAllContact(): LiveData<List<Contact>>

//THIS DOES THE ASC SORT FROM THE DATABASE
    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun getAllContactASC(): LiveData<List<Contact>>

//THIS DOES THE DESC SORT FROM THE DATABASE
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun getAllContactDESC(): LiveData<List<Contact>>
}