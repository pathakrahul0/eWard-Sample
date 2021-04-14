package com.eward.model


import com.google.gson.annotations.SerializedName

data class UserDetails(
    @SerializedName("employee_age")
    var employeeAge: Int?,
    @SerializedName("employee_name")
    var employeeName: String?,
    @SerializedName("employee_salary")
    var employeeSalary: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("profile_image")
    var profileImage: String?
)