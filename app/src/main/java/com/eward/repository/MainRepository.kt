package com.eward.repository

import com.eward.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
){
    suspend fun getEmployee() = apiHelper.getEmployees()
}