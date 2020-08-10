package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("/graphql")
interface GraphqlClient {

    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun postQuery(query: String): Single<Any>
}
