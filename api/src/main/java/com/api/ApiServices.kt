package com.api

import com.api.model.RemoteCountry
import retrofit2.http.GET

interface ApiServices {
    @GET("v2/all")
    suspend fun getCountries(): List<RemoteCountry>
}