package com.sparjapati.workManager

import retrofit2.http.GET

interface NetworkApi {

    companion object {
        const val BASE_URl = "https://jsonplaceholder.typicode.com/"
    }

    @GET("todos/1")
    suspend fun getTodo(): Todo
}
