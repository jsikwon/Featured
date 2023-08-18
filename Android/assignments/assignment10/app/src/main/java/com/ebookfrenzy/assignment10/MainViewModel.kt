package com.ebookfrenzy.assignment10

import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {


    fun getTitles(): MutableList<String> {
        return titles
    }


    private val titles = mutableListOf<String>()

    fun addTitle(title: String) {
        titles.add(title)
    }



}
