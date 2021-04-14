package com.eward.api

import com.eward.model.UserList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("employees")
    suspend fun fetchUser(): Response<UserList>
}