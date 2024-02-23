package com.avoxis.diskominfointerview.network


import com.avoxis.diskominfointerview.createupdate.model.CreateWidgetResponse
import com.avoxis.diskominfointerview.createupdate.model.UpdateWidgetResponse
import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.PartMap
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiInterface {
    @POST("/login")
    fun getLogin(
        @Header("Authorization") staticTokenV2: String,
        @Body requestParam: RequestBody
    ): Observable<ResponseBody>

    @Multipart
    @GET("/allwidgets")
    fun getAllWidget(
        @Header("Authorization") bearerToken: String,
        @Query("page") page: Int,
        @Query("page_size") page_size: Int
    ): Observable<GetAllWidgetResponse>

    @Multipart
    @POST("/widget")
    fun createWidget(
        @Header("Authorization") bearerToken: String,
        @Body data: RequestBody
    ): Observable<CreateWidgetResponse>

    @Multipart
    @PUT("/widget")
    fun updateWidget(
        @Header("Authorization") bearerToken: String,
        @Body data: RequestBody,
        @Query("id") id: String
    ): Observable<UpdateWidgetResponse>
}