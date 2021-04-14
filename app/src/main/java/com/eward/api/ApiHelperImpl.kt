package com.eward.api

import com.eward.model.UserList
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
):ApiHelper{
    override suspend fun getEmployees(): Response<UserList> = apiService.fetchUser()
}