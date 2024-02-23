package com.avoxis.diskominfointerview.main.model

import com.google.gson.annotations.SerializedName

data class WidgetModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("opt")
    val opt: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("creator")
    val creator: Int?,
    @SerializedName("app_id")
    val appId: Int?,
    @SerializedName("iconfab")
    val iconfab: String?,
    @SerializedName("allpages")
    val allpages: String?,
    @SerializedName("publish")
    val publish: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("update_at")
    val updateAt: String?,
    @SerializedName("delete_at")
    val deleteAt: String?
)