package com.avoxis.diskominfointerview.network


import com.avoxis.diskominfointerview.main.model.GetAllWidgetResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.QueryMap

interface ApiInterface {
    @POST("/login")
    fun getLogin(
        @Header("Authorization") staticTokenV2: String,
        @Body requestParam: RequestBody
    ): Observable<ResponseBody>
    @GET("/allwidgets")
    fun getAllWidget(
        @QueryMap data: HashMap<String, Any>
    ): Observable<GetAllWidgetResponse>
    @POST("/widget")
    fun createWidget(
        @Body data: RequestBody
    ): Observable<ResponseBody>
}