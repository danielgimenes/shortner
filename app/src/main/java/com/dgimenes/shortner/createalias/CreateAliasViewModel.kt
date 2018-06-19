package com.dgimenes.shortner.createalias

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.dgimenes.shortner.data.AliasRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CreateAliasViewModel(private val aliasRepository: AliasRepository) : ViewModel() {

    private val aliasLiveData by lazy {
        MutableLiveData<String>()
    }

    fun createAliasForLink(originalLink: String): LiveData<String> {
        aliasRepository.createAliasForLink(originalLink)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ alias ->
                    aliasLiveData.value = alias
                }, { error ->
                    error.printStackTrace()
                    // TODO error handling
                })
        return aliasLiveData
    }

}