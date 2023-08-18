package com.ebookfrenzy.contactfinal.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.contactfinal.Contact
import com.ebookfrenzy.final.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel
    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val allContactsASC: LiveData<List<Contact>>?
    private val allContactsDESC: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        allContactsASC = repository.allContactsASC
        allContactsDESC = repository.allContactsDESC
        searchResults = repository.searchResults
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun getAllContactsASC(): LiveData<List<Contact>>? {
        return allContactsASC
    }
    fun getAllContactsDESC(): LiveData<List<Contact>>? {
        return allContactsDESC
    }


}