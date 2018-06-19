package com.dgimenes.shortner

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.dgimenes.shortner.data.AliasRepository
import com.dgimenes.shortner.data.remote.AliasWebService
import com.dgimenes.shortner.data.remote.CreateAliasPayload
import com.dgimenes.shortner.data.remote.CreateAliasResult
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class CreateAliasRepositoryTest {

    @Suppress("unused")
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun createAliasFromLink_expectedOutput() {
        val originalLink = "https://www.wikipedia.com/"
        val expectedAlias = "https://nubank-shortner.com/?goto=$originalLink"
        val webservice = Mockito.mock(AliasWebService::class.java)
        val mockPayload = CreateAliasPayload(url = originalLink)
        val mockResult = CreateAliasResult(alias = expectedAlias)
        `when`(webservice.createAlias(mockPayload)).thenReturn(Single.just(mockResult))
        val repository = AliasRepository(webservice)

        val alias = repository.createAliasForLink(originalLink).blockingGet()

        assertEquals(expectedAlias, alias)
    }

}