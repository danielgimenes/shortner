package com.dgimenes.shortner.di

import dagger.Component

@Component(modules = arrayOf(WebServiceModule::class, RepositoryModule::class))
interface BaseComponentGraph {

    fun newCreateAliasComponent(createAliasModule: CreateAliasModule): CreateAliasComponent

}