package com.dgimenes.shortner

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.dgimenes.shortner.createalias.CreateAliasViewModel
import com.dgimenes.shortner.data.AliasRepository
import com.dgimenes.shortner.utils.RxJavaSchedulersSetupRule
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class CreateAliasViewModelTest {

    @Suppress("unused")
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Suppress("unused")
    @get:Rule
    val rxJavaSchedulersRule = RxJavaSchedulersSetupRule()

    @Test
    fun createAliasFromLink_expectedOutput() {
        val originalLink = "https://www.wikipedia.com/"
        val expectedAlias = "https://nubank-shortner.com/?goto=$originalLink"
        val repository = Mockito.mock(AliasRepository::class.java)
        `when`(repository.createAliasForLink(originalLink)).thenReturn(Single.just(expectedAlias))

        val resultData = CreateAliasViewModel(repository).createAliasForLink(originalLink)

        assertEquals(expectedAlias, resultData.value)
    }

}