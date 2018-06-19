package com.dgimenes.shortner.createalias

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CreateAliasViewModel: ViewModel() {

    private val aliasData by lazy {
        MutableLiveData<String>()
    }

    fun createAliasForLink(originalLink: String): LiveData<String> {
        aliasData.value = "https://nubank-shortner.com/?goto=$originalLink"
        return aliasData
    }

}