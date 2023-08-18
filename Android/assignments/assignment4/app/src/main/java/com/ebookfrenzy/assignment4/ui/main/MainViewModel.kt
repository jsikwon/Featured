package com.ebookfrenzy.assignment4.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var nameList: ArrayList<String> = ArrayList()

    fun addName(s: String) {
        nameList.add(s)
    }

    fun getName(): ArrayList<String> {
            return nameList
    }


}