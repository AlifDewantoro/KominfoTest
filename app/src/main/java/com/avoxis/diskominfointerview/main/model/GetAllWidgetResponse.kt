package com.avoxis.diskominfointerview.main.model

import com.google.gson.annotations.SerializedName

data class GetAllWidgetResponse(
    @SerializedName("data")
    val data: List<WidgetModel>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?
)