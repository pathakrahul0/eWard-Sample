package com.eward.api

import com.eward.model.UserList
import retrofit2.Response

interface ApiHelper {
    suspend fun getEmployees(): Response<UserList>
}