package com.dgimenes.shortner.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dgimenes.shortner.createalias.CreateAliasActivity
import com.dgimenes.shortner.createalias.CreateAliasViewModel
import com.dgimenes.shortner.data.AliasRepository
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(CreateAliasModule::class))
interface CreateAliasComponent {

    fun inject(activity: CreateAliasActivity)

}

@Module
class CreateAliasModule {

    @Provides
    fun provideCreateAliasViewModelFactory(aliasRepository: AliasRepository): CreateAliasViewModelFactory {
        return CreateAliasViewModelFactory(aliasRepository)
    }

}

class CreateAliasViewModelFactory(val aliasRepository: AliasRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreateAliasViewModel(aliasRepository) as T
    }

}
