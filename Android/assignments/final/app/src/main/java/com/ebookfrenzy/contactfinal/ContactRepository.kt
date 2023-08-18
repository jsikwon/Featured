package com.ebookfrenzy.final

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {


    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDAO: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    var allContacts: LiveData<List<Contact>>?
    var allContactsASC: LiveData<List<Contact>>?
    var allContactsDESC: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDAO = db?.contactDAO()
        allContacts = contactDAO?.getAllContact()

        allContactsASC = contactDAO?.getAllContactASC()
        allContactsDESC = contactDAO?.getAllContactDESC()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }
    private suspend fun asyncInsert(contact: Contact) {
        contactDAO?.insertContact(contact)
    }
    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }
    private suspend fun asyncDelete(id: Int) {
        contactDAO?.deleteContact(id)
    }
    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDAO?.findContact(name)
        }
}
