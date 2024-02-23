package com.avoxis.diskominfointerview.createupdate.model

import com.google.gson.annotations.SerializedName

data class UpdateWidgetResponse(
    @SerializedName("data")
    val data: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
)
