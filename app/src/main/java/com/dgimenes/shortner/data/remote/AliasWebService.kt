package com.dgimenes.shortner.data.remote

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AliasWebService {

    @POST("api/alias")
    fun createAlias(@Body payload: CreateAliasPayload): Single<CreateAliasResult>

}

data class CreateAliasPayload(val url: String)

data class CreateAliasResult(val alias: String)