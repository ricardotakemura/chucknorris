package com.sensedia.poc.android.model.service

import com.sensedia.poc.android.model.bean.Fact
import com.sensedia.poc.android.model.bean.Facts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FactService {

    @GET("/jokes/search")
    fun getFacts(@Query("query") query: String): Call<Facts>
}