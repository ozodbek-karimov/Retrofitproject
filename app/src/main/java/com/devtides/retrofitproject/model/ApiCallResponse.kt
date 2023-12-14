package com.devtides.retrofitproject.model

import com.google.gson.annotations.SerializedName

data class ApiCallResponse(
    val method: String?,
    val query: Map<String,String>?,
    @SerializedName("headers")
    val heads: Map<String, String>
)