package com.ebookfrenzy.assignment5.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    var newName: MutableLiveData<String> = MutableLiveData()
    var nameList: MutableList<String> = mutableListOf()
    //1) var nameList: ArrayList<String> = ArrayList()
    //2) val liveList:
    fun displayName(): String {
        newName.let {
            if(it.value != ""){
                nameList.add(it.toString())
                //1) nameList.add(it.toString())
                //1) nameList.joinToString(prefix = "", separator = "\n", postfix = "")
                //2) nameList.observe(this) {list -> showList(list)}

                // println(nameList)
            } else {
                nameList.add("No Names to display")
                // println(nameList)
            }
        }
        return nameList.toString()
        //return nameList.joinToString(prefix = "", separator = "\n", postfix = "")
    }

}