package com.dgimenes.shortner.di

import com.dgimenes.shortner.data.AliasRepository
import com.dgimenes.shortner.data.remote.AliasWebService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideAliasRepository(aliasWebService: AliasWebService): AliasRepository =
            AliasRepository(aliasWebService)

}