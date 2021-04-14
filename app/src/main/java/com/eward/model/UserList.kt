package com.eward.model


import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("data")
    var `data`: ArrayList<UserDetails>?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("status")
    var status: String?
)