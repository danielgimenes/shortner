package com.dgimenes.shortner

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.dgimenes.shortner.createalias.CreateAliasViewModel
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CreateAliasViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun createAliasFromLink_expectedOutput() {
        val originalLink = "https://www.wikipedia.com/"
        val expectedAlias = "https://nubank-shortner.com/?goto=$originalLink"

        val resultData = CreateAliasViewModel().createAliasForLink(originalLink)

        assertEquals(expectedAlias, resultData.value)
    }

}