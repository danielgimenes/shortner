package com.dgimenes.shortner.data

import com.dgimenes.shortner.data.remote.AliasWebService
import com.dgimenes.shortner.data.remote.CreateAliasPayload
import io.reactivex.Single

open class AliasRepository(private val aliasWebService: AliasWebService) {

    open fun createAliasForLink(originalLink: String): Single<String> {
        return aliasWebService.createAlias(CreateAliasPayload(url = originalLink))
                .map { result ->
                    result.alias
                }
    }

}